package com.zhp.springcloud.server.export;

import com.zhp.springcloud.server.api.DemoService;
import com.zhp.springcloud.server.api.dto.ReqDemo;
import com.zhp.springcloud.server.api.dto.ReqObject;
import com.zhp.springcloud.server.api.res.ResDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zhp.dts
 * @date 2018/12/18
 */
@RestController
@RequestMapping("/demo")
public class DemoExportRest{
    @Autowired
    private DemoService demoService;

    @RequestMapping("/hello")
    @ResponseBody
    public String helloWorld(String name) {
        return demoService.helloWorld(name);
    }

    @RequestMapping("/helloObj")
    @ResponseBody
    public ResDemo helloObject(@RequestBody ReqDemo reqDemo) {
        return demoService.helloObject(reqDemo);
    }

    @RequestMapping("/helloList")
    @ResponseBody
    public ResDemo helloList(@RequestBody List<ReqDemo> reqDemos) {
        return demoService.helloList(reqDemos);
    }


    @RequestMapping("/helloReqObj")
    @ResponseBody
    public ResDemo helloReqObject(@RequestBody ReqObject<ReqDemo> reqDemo) {
        return demoService.helloObject(reqDemo.getBody());
    }

}
