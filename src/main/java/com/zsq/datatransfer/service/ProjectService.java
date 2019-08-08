package com.zsq.datatransfer.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zsq.datatransfer.mapper.TransferFileTypeMapper;
import com.zsq.datatransfer.mapper.TransferProjectMapper;
import com.zsq.datatransfer.model.TransferFileType;
import com.zsq.datatransfer.model.TransferProject;
import com.zsq.datatransfer.po.TransferProjectVo;
import com.zsq.datatransfer.utils.RestResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ProjectService {
    /*
    创建项目
     */
    @Autowired
    private TransferProjectMapper transferProjectMapper;

    @Autowired
    private TransferFileTypeMapper transferFileTypeMapper;

    public RestResult addProject(TransferProject transferProject) {
        transferProject.setCreateDate(new Date());
        transferProjectMapper.insertSelective(transferProject);
        return new RestResult();
    }

    /*
    查找文件类型
     */
    public RestResult findFiles() {
        List<TransferFileType> transferFileTypes = transferFileTypeMapper.selectByExample(null);
        return new RestResult(transferFileTypes);
    }

    /*
    查询所有项目信息
     */
    public RestResult findProject(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<TransferProject> transferProjects = transferProjectMapper.selectByExample(null);
        List<TransferProjectVo> transferProjectVos=new ArrayList<>();
        PageInfo pageInfo=new PageInfo(transferProjects);
        for (TransferProject transferProject : transferProjects) {
            TransferProjectVo transferProjectVo=new TransferProjectVo();
            Integer fileId = transferProject.getFileId();
            TransferFileType transferFileType = transferFileTypeMapper.selectByPrimaryKey(fileId);
            String name = transferFileType.getName();
            BeanUtils.copyProperties(transferProject,transferProjectVo);
            transferProjectVo.setFileType(name);
            transferProjectVos.add(transferProjectVo);
        }
        pageInfo.setList(transferProjectVos);

        return new RestResult(pageInfo);



    }
}
