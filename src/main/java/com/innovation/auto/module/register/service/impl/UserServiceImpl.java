package com.innovation.auto.module.register.service.impl;

import com.innovation.auto.entity.User;
import com.innovation.auto.mapper.UserMapper;
import com.innovation.auto.module.register.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: carver
 * @Date: 2018/12/5 11:24
 * @email lt1550919167@163.com
 * @QQ 1550919167
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;

    @Override
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
    @Override
    public User selectByUsername(String name) {
        User user = userMapper.selectByUsername(name);
        return user;
    }

    /**
     * 查询所有用户
     * @return
     */
    @Override
    public List<User> selectAllUser() {
        List<User> listUser = userMapper.selectAll();
        return listUser;
    }
    @Override
    public User selectUserById(Integer id){
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }

    /**
     * 根据用户邮箱查询用户
     * @param email
     * @return
     */
    @Override
    public User selectUserByEmail(String email) {
        User user = userMapper.selectUserByEmail(email);
        if (null != user) {
            return user;
        }else {
            return null;
        }
    }
}
