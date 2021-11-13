package com.version_hit.ServiceImpl;

import com.version_hit.Mapping.HitMapping;
import com.version_hit.PO.HitPO;
import com.version_hit.Service.HitService;
import com.version_hit.VO.HitReturnVO;
import com.version_hit.VO.HitVO;
import com.version_hit.VO.Response;
import com.version_hit.VO.ReturnVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class HitServiceImpl implements HitService {

    @Autowired
    HitMapping hitMapping;

    HashMap<String, Integer> white_sheet=new HashMap<String, Integer>();
    List<HitPO> list=new ArrayList<>();
    Global global=new Global();
    
    @Override
    public Response ifHit(HitVO hitVO) {
        if(list.size()==0||global.rules_haschange==true){
            Global.rules_haschange=false;
            list=hitMapping.getRuleList();
        }
        for (HitPO hitPO : list) {
            if (check(hitPO,hitVO)){
                return new Response("Hit!",new HitReturnVO(hitPO.getDownload_url(),hitPO.getUpdate_version_code(),hitPO.getMd5(),hitPO.getTitle(),hitPO.getUpdate_tips()));
            }
        }
        return new Response("Not Hit!",new HitReturnVO());
    }

    private boolean check(HitPO hitPO,HitVO hitVO) {
        if (    checkAid(hitPO.getAid(),hitVO.getAid()) &&
                checkPlatform(hitPO.getPlatform(),hitVO.getDevice_platform()) &&
                checkDeviceIdList(hitVO.getDevice_id()) &&
                checkUpdateVersionCode(hitPO.getMin_update_version_code(),hitVO.getUpdate_version_code(),hitPO.getMax_update_version_code()) &&
                checkOsApi(hitPO.getMin_os_api(),hitVO.getOs_api(),hitPO.getMax_os_api()) &&
                checkCpuArch(hitPO.getCpu_arch(),hitVO.getCpu_arch()) &&
                checkChannel(hitPO.getChannel(),hitVO.getChannel())&&
                checkAvailable(hitPO.isUsable())
        ){
            return true;
        }

        return false;
    }
    private boolean checkAvailable(boolean usable){
        return usable;
    }

    private boolean checkDeviceIdList(String device_id) {
        //如果哈希表没有生成，从白名单数据库里获取白名单并生成白名单哈希表
        if(white_sheet.size()==0||global.device_id_haschange==true){
            Global.device_id_haschange=false;
            List<String> device_id_list= hitMapping.getDevice_Id();
            for(String s:device_id_list){
                white_sheet.put(s,1);
            }
        }


            return white_sheet.containsKey(device_id);

       //return 1==hitMapping.findDevice_Id(device_id);
    }

    private boolean checkChannel(String target, String offer) {
        return target.equals(offer);
    }

    private boolean checkCpuArch(Integer target, Integer offer) {
        return target.intValue()==offer.intValue();
    }

    private boolean checkOsApi(Integer targetMin, Integer offer, Integer targetMax) {
        return (targetMin<=offer && offer<=targetMax);
    }

    private boolean checkUpdateVersionCode(String targetMin, String offer,String targetMax) {
        return (versionCompare(targetMin,offer)<=0 && versionCompare(offer,targetMax)<=0);
    }

    private boolean checkPlatform(String target, String offer) {
        return target.equals(offer);

    }

    private boolean checkAid(Integer target, Integer offer) {
        return target.intValue()==offer.intValue();
    }

    private int versionCompare(String version1,String version2){
        String[] v1=version1.split("\\.");
        String[] v2=version2.split("\\.");
        for (int i=0;i<Math.max(v1.length,v2.length);i++){
            int t1=i<v1.length?Integer.parseInt(v1[i]):0;
            int t2=i<v2.length?Integer.parseInt(v2[i]):0;
            if (t1<t2) return -1;
            if (t1>t2) return 1;
        }
        return 0;
    }
}
