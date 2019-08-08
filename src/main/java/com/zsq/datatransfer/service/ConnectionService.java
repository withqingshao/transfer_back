package com.zsq.datatransfer.service;

import com.zsq.datatransfer.po.ConnectionPo;
import com.zsq.datatransfer.utils.RestResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

@Service
@Slf4j
public class ConnectionService {
    /*
    测试连接
     */
    public RestResult testConnection(ConnectionPo connectionPo) {
        String type = connectionPo.getType();
        if(type.equals("1")){
            List<ConnectionPo.DomainsBean> domains = connectionPo.getDomains();
            String username="";
            String password="";
            String url="";
            String ip="";
            String port="";
            String db="";
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
            } catch (SQLException e) {
                log.error(""+e);
                return new RestResult(RestResult.Status.FAILURE,"连接错误，请检查信息！！");
            }
        }
        return new RestResult();
    }
}
