package com.example.variousdemo.exception;

import com.example.variousdemo.entity.RestResult;
import com.example.variousdemo.entity.ResultCode;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.security.SignatureException;


/**
 * @className: PermissionHandler
 * @description: 统一异常处理类
 * @created: 2021/08/30 09:30
 */
@RestControllerAdvice
public class PermissionHandler {

    @ExceptionHandler(value = SignatureException.class)
    public RestResult authorizationException(SignatureException signatureException){
        return RestResult.error(ResultCode.ERROR,signatureException.getMessage());

    }
}
