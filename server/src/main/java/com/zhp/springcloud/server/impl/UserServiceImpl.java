package com.zhp.springcloud.server.impl;

import com.alibaba.druid.support.json.JSONUtils;
import com.zhp.springcloud.dao.UserDao;
import com.zhp.springcloud.dao.entity.User;
import com.zhp.springcloud.server.api.UserService;
import com.zhp.springcloud.server.api.res.ResDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhp.dts
 * @date 2018/12/19.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public ResDemo getUserById(String id) {
        ResDemo resDemo = new ResDemo();
        User user = userDao.getUserById(id);
        resDemo.setMsg(user.getUserName());
        resDemo.setCode(id);
        return resDemo;
    }
}
