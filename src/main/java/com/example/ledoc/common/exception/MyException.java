package com.example.ledoc.common.exception;

import com.example.ledoc.common.result.ResultEnum;

/**
 * @author whl
 * @Description 自定义异常
 * @date 2023/4/30 23:21
 */
public class MyException extends Exception {
    private Integer code;
    private String msg;

    public MyException() {
        super();
    }

    public MyException(String msg) {
        super(msg);
    }

    public MyException(Integer code, String msg) {
        super(msg);
        this.code = code;
    }

    public MyException(ResultEnum resultEnum) {
        this.code = resultEnum.getCode();
        this.msg = resultEnum.getMsg();
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
