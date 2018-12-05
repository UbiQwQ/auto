package com.innovation.auto.mapper;

import com.innovation.auto.entity.MotorInfo;

public interface MotorInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MotorInfo record);

    int insertSelective(MotorInfo record);

    MotorInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MotorInfo record);

    int updateByPrimaryKey(MotorInfo record);
}