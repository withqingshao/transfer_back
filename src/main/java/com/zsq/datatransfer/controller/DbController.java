package com.zsq.datatransfer.controller;

import com.zsq.datatransfer.service.DbService;
import com.zsq.datatransfer.utils.RestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
数据源相关的
 */
@RestController
@RequestMapping("/db")
public class DbController {

    @Autowired
    private DbService dbService;

    @GetMapping("/info")
    public RestResult dbInfo(){
        return dbService.findDbInfo();
    }
}
