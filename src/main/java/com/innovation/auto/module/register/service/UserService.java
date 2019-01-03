package com.innovation.auto.module.register.service;

import com.innovation.auto.entity.User;

import java.util.List;

/**
 * @Auther: Innovation
 * @Date: 2018/9/3 15:14
 * @Vison: 1.0
 * @Description:
 */
public interface UserService {

    String register(User user);

    User selectByUsername(String name);

    List<User> selectAllUser();

    User selectUserById(Integer id);
}
