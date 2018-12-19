package com.zhp.springcloud.consumer.client;

import com.zhp.springcloud.server.api.DemoService;
import com.zhp.springcloud.server.api.dto.ReqDemo;
import com.zhp.springcloud.server.api.res.ResDemo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author zhp.dts
 * @date 2018/12/18.
 */
@FeignClient(name = "demo-server" ,path = "/demo")
public interface DemoServiceClient {
    @RequestMapping("/hello")
    String helloWorld(@RequestParam("name") String name);

    @RequestMapping("/helloObj")
    ResDemo helloObject(@RequestBody ReqDemo reqDemo);

    @RequestMapping("/helloList")
    ResDemo helloList(@RequestBody List<ReqDemo> reqDemo);
}
