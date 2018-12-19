package com.zhp.springcloud.server.export;

import com.zhp.springcloud.server.api.UserService;
import com.zhp.springcloud.server.api.res.ResDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhp.dts
 * @date 2018/12/19.
 */
@RestController
@RequestMapping("/user")
public class UserExportRest {
    @Autowired
    private UserService userService;
    @RequestMapping("/get")
    @ResponseBody
    public ResDemo getUser(String id) {
        return userService.getUserById(id);
    }
}
