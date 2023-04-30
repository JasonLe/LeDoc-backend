package com.example.ledoc.common.result;

import com.example.ledoc.common.exception.MyException;

/**
 * @author whl
 * @Description 结果返回值类
 * @date 2023/4/30 16:58
 */
public class Result<T> {
    private Integer code;
    private String msg;
    private T data;

    public Result() {
    }

    public Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
        this.data = null;
    }

    public Result(ResultEnum resultEnum) {
        this.code = resultEnum.getCode();
        this.msg = resultEnum.getMsg();
        this.data = null;
    }

    public Result(ResultEnum resultEnum, T data) {
        this.code = resultEnum.getCode();
        this.msg = resultEnum.getMsg();
        this.data = data;
    }

    protected Result(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> Result<T> success() {
        return new Result<>(ResultEnum.SUCCESS_CODE);
    }

    public static <T> Result<T> success(T data) {
        return new Result<>(ResultEnum.SUCCESS_CODE, data);
    }

    public static <T> Result<T> failed() {
        return new Result<>(ResultEnum.FAILED);
    }

    public static <T> Result<T> failed(T data) {
        return new Result<>(ResultEnum.FAILED, data);
    }

    public static <T> Result<T> failed(MyException e) {
        return new Result<>(e.getCode(), e.getMsg());
    }

    public static <T> Result<T> define(int code, String msg, T data) {
        return new Result<>(code, msg, data);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
