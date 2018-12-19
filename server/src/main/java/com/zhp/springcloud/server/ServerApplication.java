package com.zhp.springcloud.server;

import com.netflix.discovery.DiscoveryClient;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.core.env.PropertySourcesPropertyResolver;
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
    private final static Logger log = LoggerFactory.getLogger(ServerApplication.class);
    public static void main(String[] args){
        SpringApplication.run(ServerApplication.class,args);
        log.error("error -------------------------------------");
        log.info("----info -------------------------------------");
        log.debug("-------debug -------------------------------------");
    }
}
