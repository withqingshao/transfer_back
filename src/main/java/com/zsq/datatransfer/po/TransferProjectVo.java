package com.zsq.datatransfer.po;

import com.zsq.datatransfer.model.TransferProject;

public class TransferProjectVo extends TransferProject {

    private  String fileType;

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }
}
