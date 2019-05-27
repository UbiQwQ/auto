package com.innovation.auto.mapper;

import com.innovation.auto.entity.MotorInfo;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
    List<LinkedHashMap<String,String>> selectAuto(Map<String,Object> map);

    /*
     * @Description 分类查看机车信息
     * @Date 2019/5/15 23:02
     * @Param []
     * @Return java.util.List<java.util.HashMap<java.lang.String,java.lang.Object>>
     **/
    List<HashMap<String,Object>> selectByCategory();

    /**
     * @Description 特定motor详细信息
     * @Date 2019/5/25 12:27
     * @Param []
     * @Return java.util.HashMap<java.lang.String , java.lang.String>
     **/
    LinkedHashMap<String,String> selectByMotorId(Integer id);


}