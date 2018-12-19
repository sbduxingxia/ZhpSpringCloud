package com.zhp.springcloud.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author zhp.dts
 * @date 2018/12/17.
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaRegisterCenterApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaRegisterCenterApplication.class, args);
    }
}
