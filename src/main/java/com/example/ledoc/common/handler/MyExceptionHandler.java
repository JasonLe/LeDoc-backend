package com.example.ledoc.common.handler;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.example.ledoc.common.exception.MyException;
import com.example.ledoc.common.result.Result;
import com.example.ledoc.common.utils.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author whl
 * @Description
 * @date 2023/4/30 23:28
 */
@Slf4j
@RestControllerAdvice
public class MyExceptionHandler {
    @ExceptionHandler(value = {MyException.class})
    @ResponseBody
    public Result myException(MyException e) {
        log.error(e.getMsg());
        return Result.failed(e);
    }

    @ExceptionHandler(value = {Exception.class})
    @ResponseBody
    public Result myException(Exception e) {
        log.error(e.getMessage());
        return Result.failed(e);
    }

    @ExceptionHandler(value = {JWTVerificationException.class})
    @ResponseBody
    public Result myException(JWTVerificationException e) {
        log.error(e.getMessage());
        return Result.failed(JwtUtil.header + "失效，请重新登录。");
    }
}
