package com.innovation.auto.module.info.service;

import com.innovation.auto.entity.Article;

import java.util.List;

/**
 * @Auther: carver
 * @Date: 2019/1/4 20:18
 * @email lt1550919167@163.com
 * @QQ 1550919167
 * @Description:
 */
public interface ArticleService {

    /**
     * 发布一条资讯
     * @param record
     * @return
     */
    int insert(Article record);

    /**
     * 根据资讯文章主键删除文章
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 查询所有资讯文章
     * @return
     */
    List<Article> selectAllInfo(Article article);


}
