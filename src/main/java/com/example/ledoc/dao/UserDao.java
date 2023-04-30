package com.example.ledoc.dao;

import com.example.ledoc.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
    User getUserById(Integer userId);
}
