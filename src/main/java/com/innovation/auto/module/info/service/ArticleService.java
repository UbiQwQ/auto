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
     * 查询所有资讯文章
     * @return
     */
    List<Article> selectAllInfo();
}
