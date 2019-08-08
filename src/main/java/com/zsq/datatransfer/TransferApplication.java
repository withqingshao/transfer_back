package com.zsq.datatransfer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.zsq.datatransfer.mapper")
@EnableTransactionManagement
/*
github 项目维护22
 */
public class TransferApplication {

    public static void main(String[] args) {
        SpringApplication.run(TransferApplication.class, args);
    }

}
