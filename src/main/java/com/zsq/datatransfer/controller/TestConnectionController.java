package com.zsq.datatransfer.controller;

import com.zsq.datatransfer.po.ConnectionPo;
import com.zsq.datatransfer.service.ConnectionService;
import com.zsq.datatransfer.utils.RestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/datasource")
public class TestConnectionController {

    @Autowired
    private ConnectionService connectionService;

     @PostMapping("/connection")
     public RestResult testConnection(@RequestBody ConnectionPo connectionPo){
         return connectionService.testConnection(connectionPo);

     }


}
