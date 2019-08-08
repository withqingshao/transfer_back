package com.zsq.datatransfer.gloab;

import com.zsq.datatransfer.utils.RestConst;
import com.zsq.datatransfer.utils.RestResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
@Slf4j
 public class GlobalExceptionHandler {
     @ExceptionHandler(RuntimeException.class)
     //    @ExceptionHandler(value={RuntimeException.class,MyRuntimeException.class})
     //    @ExceptionHandler//处理所有异常
     @ResponseBody //在返回自定义相应类的情况下必须有，这是@ControllerAdvice注解的规定
     public RestResult exceptionHandler(RuntimeException e, HttpServletResponse response) {
         log.info("----系统异常消息----");
         log.error("异常消息",e);
         RestResult restResult=new RestResult();
         restResult.setMessage(e.getMessage()).setCode(RestConst.SysError.SYS_ERROR).setStatus(RestResult.Status.FAILURE);
         return restResult;
    }
    @ExceptionHandler(CustomException.class)
    @ResponseBody
    public RestResult exceptionHandler(CustomException e,HttpServletResponse response){
         log.info("----业务异常消息---");
         log.error("异常消息",e);
        RestResult restResult = new RestResult();
        restResult.setMessage(e.getMessage()).setCode(RestConst.BizError.BIZ_ERROR).setStatus(RestResult.Status.FAILURE);
        return restResult;
    }
 }