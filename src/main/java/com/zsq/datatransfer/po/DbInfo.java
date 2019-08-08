package com.zsq.datatransfer.po;

import com.google.gson.annotations.SerializedName;
import com.zsq.datatransfer.model.TransferDatasource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DbInfo {
    /**
     * dbOptions : [{"value":"1","label":"mysql"},{"value":"2","label":"oracle"},{"value":"3","label":"postpresql"}]
     * dbParameters : {"1":["ip","port","db","username","password"],"2":["username","password"]}
     */

    private Map<Integer,List<String>> dbParameters=new HashMap<>();
    private List<TransferDatasource> dbOptions;


    public List<TransferDatasource> getDbOptions() {
        return dbOptions;
    }

    public void setDbOptions(List<TransferDatasource> dbOptions) {
        this.dbOptions = dbOptions;
    }


    public Map<Integer, List<String>> getDbParameters() {
        return dbParameters;
    }

    public void setDbParameters(Map<Integer, List<String>> dbParameters) {
        this.dbParameters = dbParameters;
    }
}
