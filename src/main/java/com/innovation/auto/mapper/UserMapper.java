package com.innovation.auto.mapper;

import com.innovation.auto.entity.User;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**
     * 查询所有用户
     * @return
     */
    List<User> selectAll();

    /**
     * 根据用户名查询用户
     * @param name
     * @return
     */
    User selectByUsername(String name);

    /**
     * 根据用户邮箱查询用户
     * @param email
     * @return
     */
    User selectUserByEmail(String email);
}