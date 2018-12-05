package com.innovation.auto.mapper;

import com.innovation.auto.entity.Dic;
import com.innovation.auto.entity.DicExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DicMapper {
    int countByExample(DicExample example);

    int deleteByExample(DicExample example);

    int deleteByPrimaryKey(Integer dicId);

    int insert(Dic record);

    int insertSelective(Dic record);

    List<Dic> selectByExample(DicExample example);

    Dic selectByPrimaryKey(Integer dicId);

    int updateByExampleSelective(@Param("record") Dic record, @Param("example") DicExample example);

    int updateByExample(@Param("record") Dic record, @Param("example") DicExample example);

    int updateByPrimaryKeySelective(Dic record);

    int updateByPrimaryKey(Dic record);
}