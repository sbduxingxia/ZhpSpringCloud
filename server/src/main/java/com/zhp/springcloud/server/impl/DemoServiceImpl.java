package com.zhp.springcloud.server.impl;

import com.zhp.springcloud.dao.UserDao;
import com.zhp.springcloud.server.api.DemoService;
import com.zhp.springcloud.server.api.dto.ReqDemo;
import com.zhp.springcloud.server.api.res.ResDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhp.dts
 * @date 2018/12/17.
 */
@Service
public class DemoServiceImpl implements DemoService {
    @Autowired
    private UserDao userDao;
    @Override
    public String helloWorld(String name) {
        return "DemoService say : hello "+name;
    }

    @Override
    public ResDemo helloObject(ReqDemo demoObject) {
        ResDemo resDemo = new ResDemo();
        resDemo.setMsg("hello "+demoObject.getName());
        resDemo.setCode("userId : "+demoObject.getUserId());
        return resDemo;
    }

    @Override
    public ResDemo helloList(List<ReqDemo> reqDemos) {
        ResDemo resDemo = new ResDemo();
        String names = "";
        String userIds = "";
        for(ReqDemo reqDemo : reqDemos){
            names += reqDemo.getName()+" ";
            userIds += reqDemo.getUserId()+" ";
        }
        resDemo.setMsg("hello "+names);
        resDemo.setCode("userIds is "+userIds);
        return resDemo;
    }

}
