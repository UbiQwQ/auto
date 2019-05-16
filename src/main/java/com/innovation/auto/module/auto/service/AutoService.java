package com.innovation.auto.module.auto.service;

import com.innovation.auto.entity.MotorInfo;

import java.util.List;
import java.util.Map;

/**
 * @Auther: carver
 * @Date: 2018/12/25 09:21
 * @email lt1550919167@163.com
 * @QQ 1550919167
 * @Description:
 */
public interface AutoService {

    /**
     * 查询所有汽车信息
     * @return
     */
    List<MotorInfo> selectAuto(Map<String,Object> map);

    int deleteByPrimaryKey(Integer id);

    int insert(MotorInfo record);

//    int insertSelective(MotorInfo record);
//    MotorInfo selectByPrimaryKey(Integer id);
    int updateByPrimaryKeySelective(MotorInfo record);

//    int updateByPrimaryKey(MotorInfo record);

}
