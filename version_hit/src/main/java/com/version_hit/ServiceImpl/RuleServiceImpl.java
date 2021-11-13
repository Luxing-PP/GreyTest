package com.version_hit.ServiceImpl;

import com.version_hit.Mapping.RuleMapping;
import com.version_hit.Service.RuleService;
import com.version_hit.VO.Response;
import com.version_hit.VO.ReturnVO;
import com.version_hit.VO.RuleVO;
import com.version_hit.VO.SuspendPairVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.Mapping;

import java.util.ArrayList;


@Component
public class RuleServiceImpl implements RuleService {


    @Autowired
    RuleMapping ruleMapping;
    Global global;

    @Override
    public Response addRules(RuleVO ruleVO) {
        global.rules_haschange=true;
        int res=ruleMapping.insertRule(ruleVO);
        if(res==0){
            return new Response("INSERT FAILED!", new ReturnVO(res));
        }
        return new Response("INSERT SUCCESSFULLY!",new ReturnVO(res));
    }

    public Response addIDs(String ids){
        global.device_id_haschange=true;
        String[] device_id_lists=ids.split(",");
        int res=0;
        for(String id:device_id_lists){
            res=ruleMapping.insertID(id);

        }
        if(res==0){
            return new Response("INSERT FAILED!", new ReturnVO(res));
        }
        return new Response("INSERT SUCCESSFULLY!",new ReturnVO(res));

    }

    @Override
    public Response deleteRule(String id) {
        global.rules_haschange=true;
        int res=0;
        res=ruleMapping.deleteRule(Integer.parseInt(id));
        if(res==0){
            return new Response("DELETE FAILED!", new ReturnVO(res));
        }
        return new Response("DELETE SUCCESSFULLY!",new ReturnVO(res));
    }

    @Override
    public Response suspendRule(String id,String status){
        global.rules_haschange=true;
        SuspendPairVo spv;
        if(status.equals("0")){
            spv=new SuspendPairVo(Integer.parseInt(id),false);
        }
        else {
            spv=new SuspendPairVo(Integer.parseInt(id),true);
        }
        int res= ruleMapping.suspendRule(spv);
        if(res==0){
            return new Response("SUSPEND FAILED!", new ReturnVO(res));
        }
        return new Response("SUSPEND SUCCESSFULLY!",new ReturnVO(res));
    }


}
