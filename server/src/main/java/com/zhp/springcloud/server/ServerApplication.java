package com.zhp.springcloud.server;

import com.netflix.discovery.DiscoveryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhp.dts
 * @date 2018/12/17.
 */
@SpringBootApplication
@EnableEurekaClient
public class ServerApplication {
    public static void main(String[] args){
        SpringApplication.run(ServerApplication.class,args);
    }
}
