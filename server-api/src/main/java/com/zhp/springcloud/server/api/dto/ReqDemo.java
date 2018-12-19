package com.zhp.springcloud.server.api.dto;

/**
 * @author zhp.dts
 * @date 2018/12/19.
 */
public class ReqDemo {
    private String name;
    private String userId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
