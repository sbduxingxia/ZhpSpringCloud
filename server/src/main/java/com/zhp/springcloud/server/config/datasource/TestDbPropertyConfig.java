package com.zhp.springcloud.server.config.datasource;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author zhp.dts
 * @date 2018/8/24.
 */
@ConfigurationProperties(prefix = "datasource.dbtest")
public class TestDbPropertyConfig extends DbConfigProperty {
    public TestDbPropertyConfig(){

    }
}
