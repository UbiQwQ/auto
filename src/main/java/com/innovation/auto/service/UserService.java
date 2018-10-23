package com.innovation.auto.service;

import com.innovation.auto.entity.User;
import com.innovation.auto.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: Innovation
 * @Date: 2018/9/3 15:14
 * @Vison: 1.0
 * @Description:
 */
@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public String register(User user){
        int insert = userMapper.insert(user);
        if(insert != 0){
            return "success";
        }else{
            return "success";
        }
    }

    /**
     * 根据 UserName 查询 User
     * @param name 用户名
     * @return
     */
    public User selectByUsername(String name) {
        User user = userMapper.selectByUsername(name);
        return user;
    }

}
