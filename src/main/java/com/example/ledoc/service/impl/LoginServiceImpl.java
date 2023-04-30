package com.example.ledoc.service.impl;

import com.example.ledoc.common.result.Result;
import com.example.ledoc.common.result.ResultEnum;
import com.example.ledoc.common.utils.JwtUtil;
import com.example.ledoc.dao.UserDao;
import com.example.ledoc.entity.User;
import com.example.ledoc.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author whl
 * @Description
 * @date 2023/4/30 17:17
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserDao userDao;

    @Override
    public Result login(User user) {
        User userResult = userDao.getUserById(user.getUserId());
        if (userResult == null) {
            return Result.failed();
        }
        if (userResult.getUserName().equals(user.getUserName()) && userResult.getPassWord().equals(user.getPassWord())) {

            String token = JwtUtil.createToken(userResult.getUserName());
            return Result.success(token);
        } else {
            return Result.failed(ResultEnum.FAILED);
        }
    }
}
