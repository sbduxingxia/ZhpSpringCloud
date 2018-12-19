package com.zhp.springcloud.server.config.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author zhp.dts
 * @date 2018/8/24.
 */
@Configuration
@MapperScan(basePackages = "com.zhp.springcloud.dao",sqlSessionFactoryRef = "sqlSessionFactory")
@EnableConfigurationProperties({TestDbPropertyConfig.class})
public class TestDataSource {
    @Autowired
    private TestDbPropertyConfig configProperty;
    @Autowired
    private MybatisPageInterceptor interceptor;

    @Bean(name = "dataSource")
    public DataSource dataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(com.mysql.cj.jdbc.Driver.class.getName());
        dataSource.setUrl(configProperty.getUrl());
        dataSource.setUsername(configProperty.getUsername());
        dataSource.setPassword(configProperty.getPassword());
        dataSource.setMaxActive(configProperty.getMaxActive());
        dataSource.setMinIdle(configProperty.getMinIdle());
        dataSource.setInitialSize(configProperty.getInitialSize());
        dataSource.setValidationQuery(configProperty.getValidationQuery());
        dataSource.setTestOnBorrow(configProperty.isTestOnBorrow());
        dataSource.setMaxWait(configProperty.getMaxWait());
        dataSource.setMinIdle(configProperty.getMinIdle());
        dataSource.setTestWhileIdle(true);
        dataSource.setTestOnReturn(false);
        return dataSource;
    }
    @Bean(name = "dataSourceTransactionManager")
    public DataSourceTransactionManager dataSourceTransactionManager(){
        return new DataSourceTransactionManager(dataSource());
    }
    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier(value = "dataSource") DataSource dataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(configProperty.getMapperLocation()));
        sessionFactory.setPlugins(new Interceptor[]{interceptor});
        return sessionFactory.getObject();
    }
}
