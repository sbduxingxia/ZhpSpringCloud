package com.zhp.springboot.dao;

import org.junit.Before;
import org.junit.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.api.ProgressCallback;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhp.dts
 * @date 2018/12/19.
 */
public class TestGeneratorMapper {
    private File configFile;

    @Before
    public void before() {
        //读取mybatis参数
        String projectPath = System.getProperty("user.dir");
        System.out.println(System.getProperty("user.dir"));
        configFile = new File(projectPath+"/src/main/resources/generator/generatorConfig.xml");
    }

    @Test
    public void test() throws Exception{
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        ProgressCallback progressCallback = new ProgressCallback() {
            @Override
            public void introspectionStarted(int i) {

            }

            @Override
            public void generationStarted(int i) {

            }

            @Override
            public void saveStarted(int i) {

            }

            @Override
            public void startTask(String s) {

            }

            @Override
            public void done() {

            }

            @Override
            public void checkCancel() throws InterruptedException {

            }
        };
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(progressCallback);
    }
}
