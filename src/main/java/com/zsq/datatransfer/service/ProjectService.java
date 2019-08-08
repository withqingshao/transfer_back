package com.zsq.datatransfer.service;

import com.zsq.datatransfer.mapper.TransferProjectMapper;
import com.zsq.datatransfer.model.TransferProject;
import com.zsq.datatransfer.utils.RestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProjectService {
    /*
    创建项目
     */
    @Autowired
    private TransferProjectMapper transferProjectMapper;
    public RestResult addProject(TransferProject transferProject) {
        transferProjectMapper.insertSelective(transferProject);
        return new RestResult();
    }
}
