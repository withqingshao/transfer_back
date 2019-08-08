package com.zsq.datatransfer.controller;

import com.google.gson.JsonObject;
import com.zsq.datatransfer.model.TransferProject;
import com.zsq.datatransfer.po.ProjectPo;
import com.zsq.datatransfer.service.ProjectService;
import com.zsq.datatransfer.utils.DateUtils;
import com.zsq.datatransfer.utils.RestResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping("/project")
@Slf4j
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping("/create")
    public RestResult createProject(@RequestBody TransferProject transferProject){

        return projectService.addProject(transferProject);


    }
    @PostMapping("/upload")
    public RestResult uploadFile(@RequestParam("file") MultipartFile file){
        if(file.isEmpty()){
            return new RestResult(RestResult.Status.FAILURE,"上传失败");
        }
        String originalFilename = file.getOriginalFilename();
        String rootDir="d://upload//";
        String date= DateUtils.dateToString(new Date());
        String directory=String.format("%s//%s",rootDir,date);
        File directoryFile=new File(directory);
        if(!directoryFile.exists()){
            directoryFile.mkdirs();
        }
        String finalPath=String.format("%s//%s//%s",rootDir,date,originalFilename);
        File destFile=new File(finalPath);
        try {
            file.transferTo(destFile);
        } catch (IOException e) {
            log.error(""+e);
            return new RestResult(RestResult.Status.FAILURE,"上传失败");
        }
        JsonObject jsonObject=new JsonObject();
        jsonObject.addProperty("name",originalFilename);
        jsonObject.addProperty("url",finalPath);
        return new RestResult(jsonObject);
    }
}
