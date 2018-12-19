package com.zhp.springcloud.server.api.dto.page;

import com.zhp.springcloud.server.api.dto.ReqBase;

import java.io.Serializable;

/**
 * @author zhp.dts
 * @date 2018/12/19.
 */
public class ReqPage extends ReqBase implements Serializable {
    private int pageSize=10;
    private int pageNo=0;
    private long totalNum;
    private String totalMappedStatementId;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public long getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(long totalNum) {
        this.totalNum = totalNum;
    }

    public String getTotalMappedStatementId() {
        return totalMappedStatementId;
    }

    public void setTotalMappedStatementId(String totalMappedStatementId) {
        this.totalMappedStatementId = totalMappedStatementId;
    }
}
