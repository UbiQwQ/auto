package com.innovation.auto.mapper;

import com.innovation.auto.entity.Article;

import java.util.List;

public interface ArticleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Article record);

    int insertSelective(Article record);

    /**
     * 根据资讯主键查询资讯
     * @param id
     * @return
     */
    Article selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKeyWithBLOBs(Article record);

    int updateByPrimaryKey(Article record);

    /**
     * 查询所有资讯文章
     * @return
     */
    List<Article> selectAllInfo(Article article);
}