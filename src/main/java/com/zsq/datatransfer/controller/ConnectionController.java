package com.zsq.datatransfer.controller;

import com.zsq.datatransfer.model.TransferConnnection;
import com.zsq.datatransfer.po.ConnectionPo;
import com.zsq.datatransfer.service.ConnectionService;
import com.zsq.datatransfer.utils.RestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/datasource")
public class ConnectionController {

    @Autowired
    private ConnectionService connectionService;

     @PostMapping("/connection")
     public RestResult testConnection(@RequestBody ConnectionPo connectionPo){
         return connectionService.testConnection(connectionPo);

     }

     @PostMapping("/save")
     public RestResult save(@RequestBody ConnectionPo connectionPo){

         return connectionService.saveConnecton(connectionPo);
     }

     /*
     数据查询
      */

     @GetMapping("/{pageNum}/{pageSize}")
     public RestResult findConnections(@PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize){
         return connectionService.findAll(pageNum,pageSize);
     }


}
