package com.zhp.springcloud.server.api;

import com.zhp.springcloud.server.api.res.ResDemo;

/**
 * @author zhp.dts
 * @date 2018/12/19.
 */
public interface UserService {
    ResDemo getUserById(String id);
}
