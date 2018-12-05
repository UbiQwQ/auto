package com.innovation.auto.mapper;

import com.innovation.auto.entity.AppAccessLog;
import com.innovation.auto.entity.AppAccessLogExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AppAccessLogMapper {
    int countByExample(AppAccessLogExample example);

    int deleteByExample(AppAccessLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AppAccessLog record);

    int insertSelective(AppAccessLog record);

    List<AppAccessLog> selectByExampleWithBLOBs(AppAccessLogExample example);

    List<AppAccessLog> selectByExample(AppAccessLogExample example);

    AppAccessLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AppAccessLog record, @Param("example") AppAccessLogExample example);

    int updateByExampleWithBLOBs(@Param("record") AppAccessLog record, @Param("example") AppAccessLogExample example);

    int updateByExample(@Param("record") AppAccessLog record, @Param("example") AppAccessLogExample example);

    int updateByPrimaryKeySelective(AppAccessLog record);

    int updateByPrimaryKeyWithBLOBs(AppAccessLog record);

    int updateByPrimaryKey(AppAccessLog record);
}