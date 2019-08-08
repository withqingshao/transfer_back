package com.zsq.datatransfer.service;

import com.zsq.datatransfer.mapper.TransferDatasourceMapper;
import com.zsq.datatransfer.mapper.TransferDatasourceParamMapper;
import com.zsq.datatransfer.model.TransferDatasource;
import com.zsq.datatransfer.model.TransferDatasourceParam;
import com.zsq.datatransfer.model.TransferDatasourceParamExample;
import com.zsq.datatransfer.po.DbInfo;
import com.zsq.datatransfer.utils.RestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DbService {

    @Autowired
    private TransferDatasourceMapper transferDatasourceMapper;

    @Autowired
    private TransferDatasourceParamMapper transferDatasourceParamMapper;
    /*
    查询信息
     */
    public RestResult findDbInfo() {
        DbInfo dbInfo=new DbInfo();
        List<TransferDatasource> transferDatasources = transferDatasourceMapper.selectByExample(null);
        dbInfo.setDbOptions(transferDatasources);
        if(transferDatasources.size()>0){
            for (TransferDatasource transferDatasource : transferDatasources) {
                Integer datasourceId = transferDatasource.getDatasourceId();
                TransferDatasourceParamExample transferDatasourceParamExample=new TransferDatasourceParamExample();
                transferDatasourceParamExample.createCriteria().andDatasourceIdEqualTo(datasourceId);
                List<TransferDatasourceParam> transferDatasourceParams = transferDatasourceParamMapper.selectByExample(transferDatasourceParamExample);
                //封装结果
                String key=""+datasourceId;
                List<String> stringList = dbInfo.getDbParameters().get(datasourceId);
                if(stringList==null){
                    stringList=new ArrayList<>();
                    dbInfo.getDbParameters().put(datasourceId,stringList);
                }
                stringList.addAll(transferDatasourceParams.stream().map(x->x.getParamName()).collect(Collectors.toList()));
            }
        }

        return new RestResult(dbInfo);
    }
}
