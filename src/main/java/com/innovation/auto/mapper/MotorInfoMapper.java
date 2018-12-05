package com.innovation.auto.mapper;


import com.innovation.auto.entity.MotorInfo;
import com.innovation.auto.entity.MotorInfoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MotorInfoMapper {
    int countByExample(MotorInfoExample example);

    int deleteByExample(MotorInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MotorInfo record);

    int insertSelective(MotorInfo record);

    List<MotorInfo> selectByExample(MotorInfoExample example);

    MotorInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MotorInfo record, @Param("example") MotorInfoExample example);

    int updateByExample(@Param("record") MotorInfo record, @Param("example") MotorInfoExample example);

    int updateByPrimaryKeySelective(MotorInfo record);

    int updateByPrimaryKey(MotorInfo record);
}