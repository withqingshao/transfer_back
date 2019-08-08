package com.zsq.datatransfer.po;

import com.zsq.datatransfer.model.TransferConnnection;

public class TransferConnectionVo extends TransferConnnection {

    private String dataSourceType;

    public String getDataSourceType() {
        return dataSourceType;
    }

    public void setDataSourceType(String dataSourceType) {
        this.dataSourceType = dataSourceType;
    }
}
