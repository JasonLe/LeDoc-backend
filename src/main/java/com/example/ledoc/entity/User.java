package com.example.ledoc.entity;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * @author whl
 * @Description 用户类
 * @date 2023/4/30 16:55
 */
@Data
public class User {
    /**
     * TODO: 增加用户权限
     */
    @NotNull
    private Integer userId;
    @NotNull
    private String userName;
    @NotNull
    private String passWord;
    private LocalDateTime createTime;
    private LocalDateTime modifyTime;
}
