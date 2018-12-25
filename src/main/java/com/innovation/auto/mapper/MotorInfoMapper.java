package com.innovation.auto.mapper;

import com.innovation.auto.entity.MotorInfo;

import java.util.List;

public interface MotorInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MotorInfo record);

    int insertSelective(MotorInfo record);

    MotorInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MotorInfo record);

    int updateByPrimaryKey(MotorInfo record);

    /**
     * 查询所有汽车信息
     * @return
     */
    List<MotorInfo> selectAuto();


}