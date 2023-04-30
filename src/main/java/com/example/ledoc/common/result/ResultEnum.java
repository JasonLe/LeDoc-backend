package com.example.ledoc.common.result;

/**
 * @author whl
 * @Description 结果返回值枚举类
 * @date 2023/4/30 16:58
 */
public enum ResultEnum {
    SUCCESS_CODE(200, "成功"),
    FAILED(500, "操作失败"),
    VALIDATE_FAILED(404, "参数检验失败"),
    UNAUTHORIZED(401, "暂未登录或token已经过期"),
    FORBIDDEN(403, "没有相关权限");

    private int code;
    private String msg;

    ResultEnum(int code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public int getCode(){
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
