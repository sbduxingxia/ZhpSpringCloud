package com.zhp.springcloud.consumer.client;

import com.zhp.springcloud.server.api.res.ResDemo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author zhp.dts
 * @date 2018/12/19.
 */
@FeignClient(name = "demo-server" ,path = "/user")
public interface UserServiceClient {
    @RequestMapping("/get")
    ResDemo getUser(@RequestParam("id") String name);
}
