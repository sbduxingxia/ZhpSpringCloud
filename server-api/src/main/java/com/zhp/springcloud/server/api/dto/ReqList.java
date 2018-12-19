package com.zhp.springcloud.server.api.dto;

import com.zhp.springcloud.server.api.dto.ReqBase;

import java.io.Serializable;
import java.util.List;

/**
 * @author zhp.dts
 * @date 2018/12/19.
 */
public class ReqList<T extends Serializable>  extends ReqBase {
    private List<T> list;

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
