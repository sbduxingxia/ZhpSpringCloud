package com.zhp.springcloud.consumer.controller;

import com.zhp.springcloud.consumer.client.DemoServiceClient;
import com.zhp.springcloud.consumer.client.UserServiceClient;
import com.zhp.springcloud.server.api.dto.ReqDemo;
import com.zhp.springcloud.server.api.res.ResDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zhp.dts
 * @date 2018/12/17.
 */
@RestController
@RequestMapping("/")
public class DemoController {
    @Autowired
    private DemoServiceClient demoServiceClient;
    @Autowired
    private UserServiceClient userServiceClient;
    @RequestMapping("/hello")
    @ResponseBody
    public String hello(String name) {
        return demoServiceClient.helloWorld(name);
    }
    @RequestMapping("/helloObj")
    @ResponseBody
    public ResDemo helloObj(@RequestBody ReqDemo reqDemo) {
        return demoServiceClient.helloObject(reqDemo);
    }
    @RequestMapping("/helloList")
    @ResponseBody
    public ResDemo helloObj(@RequestBody List<ReqDemo> reqDemos) {
        return demoServiceClient.helloList(reqDemos);
    }
    @RequestMapping("/getUser")
    @ResponseBody
    public ResDemo getUser(String id) {
        return userServiceClient.getUser(id);
    }

}
