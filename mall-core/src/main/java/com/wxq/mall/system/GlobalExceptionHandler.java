package com.wxq.mall.system;

import com.wxq.common.model.ErrorCode;
import com.wxq.common.model.ResultBody;
import com.wxq.mall.exception.BaseException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author weixiaoqiang
 * @date 2023/4/11
 **/
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Throwable.class)
    public ResultBody handleCustomException(Throwable e){
        // log.error("系统异常: ", e);
        ResultBody resultBody = ResultBody.fail("服务器异常");
        if(e instanceof BaseException){
            resultBody = ResultBody.fail(e.getMessage());
        } else {
            resultBody.setMessage("服务器异常");
            resultBody.setCode(ErrorCode.SERVER_EXCEPTION_CODE);
        }
        return resultBody;
    }
}
