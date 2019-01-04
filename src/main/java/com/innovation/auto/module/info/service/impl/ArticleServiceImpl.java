package com.innovation.auto.module.info.service.impl;

import com.innovation.auto.entity.Article;
import com.innovation.auto.mapper.ArticleMapper;
import com.innovation.auto.module.info.service.ArticleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: carver
 * @Date: 2019/1/4 20:17
 * @email lt1550919167@163.com
 * @QQ 1550919167
 * @Description:
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Resource
    private ArticleMapper articleMapper;

    @Override
    public List<Article> selectAllInfo() {
        List<Article> articles = articleMapper.selectAllInfo();
        if (null != articles) {
            return articles;
        }else {
            return null;
        }
    }
}
