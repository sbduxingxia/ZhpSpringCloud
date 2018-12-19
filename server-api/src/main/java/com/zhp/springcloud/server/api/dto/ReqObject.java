package com.zhp.springcloud.server.api.dto;

import java.io.Serializable;

/**
 * @author zhp.dts
 * @date 2018/12/19.
 */
public class ReqObject<T extends Serializable>  extends ReqBase {
    private T body;

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }
}
