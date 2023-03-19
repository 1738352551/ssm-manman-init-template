package cn.chenmanman.ssm.exception;


import cn.chenmanman.ssm.common.BaseResponse;
import cn.chenmanman.ssm.common.ErrorCode;
import cn.chenmanman.ssm.common.ResultUtils;
import cn.hutool.core.exceptions.ValidateException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 *

 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public BaseResponse<?> businessExceptionHandler(BusinessException e) {
        log.error("BusinessException", e);
        return ResultUtils.error(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    public BaseResponse<?> runtimeExceptionHandler(RuntimeException e) {
        log.error("RuntimeException", e);
        return ResultUtils.error(ErrorCode.SYSTEM_ERROR, "系统错误");
    }


    @ExceptionHandler(ValidateException.class)
    public BaseResponse validateExceptionHandler(ValidateException validateException){
        return ResultUtils.error(5000, "token失效");
    }
}
