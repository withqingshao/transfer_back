package com.zsq.datatransfer.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.zsq.datatransfer.mapper.TransferConnnectionMapper;
import com.zsq.datatransfer.mapper.TransferDatasourceMapper;
import com.zsq.datatransfer.model.TransferConnnection;
import com.zsq.datatransfer.model.TransferDatasource;
import com.zsq.datatransfer.po.ConnectionPo;
import com.zsq.datatransfer.po.TransferConnectionVo;
import com.zsq.datatransfer.utils.RestResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class ConnectionService {
    /*
    测试连接
     */
    @Autowired
    private TransferDatasourceMapper transferDatasourceMapper;


    @Autowired
    private TransferConnnectionMapper transferConnnectionMapper;

    public RestResult testConnection(ConnectionPo connectionPo) {
        Integer type = connectionPo.getType();
        TransferDatasource transferDatasource = transferDatasourceMapper.selectByPrimaryKey(type);
        if(transferDatasource!=null){
            String name = transferDatasource.getName();
            List<ConnectionPo.DomainsBean> domains = connectionPo.getDomains();
            String username="";
            String password="";
            String url="";
            String ip="";
            String port="";
            String db="";
            if(name.equalsIgnoreCase("mysql")){
                for (ConnectionPo.DomainsBean domain : domains) {
                    if(domain.getKey().equals("username")){
                        username=domain.getValue();
                    }
                    if(domain.getKey().equals("password")){
                        password=domain.getValue();
                    }
                    if(domain.getKey().equals("ip")){
                        ip=domain.getValue();
                    }
                    if(domain.getKey().equals("port")){
                        port=domain.getValue();
                    }
                    if(domain.getKey().equals("db")){
                        db=domain.getValue();
                    }
                }
                url=String.format("jdbc:mysql://%s:%s/%s",ip,port,db);
                try {
                    Connection connection = DriverManager.getConnection(url, username, password);
                    return new RestResult();
                } catch (SQLException e) {
                    log.error(""+e);
                    return new RestResult(RestResult.Status.FAILURE,"连接错误，请检查信息！！");
                }
            }
        }
        return new RestResult(RestResult.Status.FAILURE);
    }

    /*
    保存连接
     */
    public RestResult saveConnecton(ConnectionPo connectionPo) {

        /*
        数据转换
         */
        TransferConnnection transferConnnection=new TransferConnnection();
        transferConnnection.setConnectionName(connectionPo.getName());
        transferConnnection.setCreateDate(new Date());
        transferConnnection.setDatasourceId(connectionPo.getType());
        List<ConnectionPo.DomainsBean> domains = connectionPo.getDomains();
        JsonObject jsonObject=new JsonObject();
        for (ConnectionPo.DomainsBean domain : domains) {
            jsonObject.addProperty(domain.getKey(),domain.getValue());
        }
        transferConnnection.setConnectionParam(jsonObject.toString());
        transferConnnectionMapper.insertSelective(transferConnnection);
        return new RestResult();
    }

    /*
    查找所有数据源
     */
    public RestResult findAll(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<TransferConnnection> transferConnnections = transferConnnectionMapper.selectByExample(null);
        PageInfo pageInfo=new PageInfo(transferConnnections);
        List<TransferConnectionVo> transferConnectionVos=new ArrayList<>();
        for (TransferConnnection transferConnnection : transferConnnections) {
            TransferConnectionVo transferConnectionVo=new TransferConnectionVo();
            Integer datasourceId = transferConnnection.getDatasourceId();
            TransferDatasource transferDatasource = transferDatasourceMapper.selectByPrimaryKey(datasourceId);
            String name = transferDatasource.getName();
            BeanUtils.copyProperties(transferConnnection,transferConnectionVo);
            transferConnectionVo.setDataSourceType(name);
            transferConnectionVos.add(transferConnectionVo);
        }
        pageInfo.setList(transferConnectionVos);
        return new RestResult(pageInfo);
    }
}
