package com.version_hit.Controller;

import com.sun.net.httpserver.HttpServer;
import com.version_hit.Service.HitService;
import com.version_hit.VO.HitVO;
import com.version_hit.VO.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/version")
public class HitController {

    @Autowired
    HitService hitService;

    //http://127.0.0.1:8080/version/hit?version=8.1.5&device_platform=IOS&device_id=BBBB-1234&os_api=2&channel=渠道B&update_version_code=8.1.5&aid=1&cpu_arch=64


    @PostMapping ("/hit")
    @CrossOrigin
    public Response Hit(@RequestBody HitVO hitVO){
        return hitService.ifHit(hitVO);

    }
//    public Response Hit(@RequestParam("version") String version,
//                        @RequestParam("device_platform") String device_platform,
//                        @RequestParam("device_id") String device_id,
//                        @RequestParam("os_api") String os_api,
//                        @RequestParam("channel") String channel,
//                        @RequestParam("update_version_code") String update_version_code,
//                        @RequestParam("aid") String aid,
//                        @RequestParam("cpu_arch") String cpu_arch){
//        return hitService.ifHit(new HitVO(version,device_platform,device_id,Integer.parseInt(os_api),
//                channel,update_version_code,Integer.parseInt(aid),Integer.parseInt(cpu_arch)));
//    }

}
