package com.zhp.springcloud.server.api;

import com.zhp.springcloud.server.api.dto.ReqDemo;
import com.zhp.springcloud.server.api.res.ResDemo;

import java.util.List;

/**
 * @author zhp.dts
 * @date 2018/12/17.
 */
public interface DemoService {
    String helloWorld(String name);

    ResDemo helloObject(ReqDemo demoObject);

    ResDemo helloList(List<ReqDemo> demoObject);


}
