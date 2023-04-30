package com.example.ledoc.service;

import com.example.ledoc.common.exception.MyException;
import com.example.ledoc.common.result.Result;
import com.example.ledoc.entity.User;

/**
 * @author whl
 * @Description
 * @date 2023/4/30 17:17
 */
public interface LoginService {
    Result login(User user);
}
