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
    public Article selectByPrimaryKey(Integer id) {
        Article article = articleMapper.selectByPrimaryKey(id);
        return article;
    }

    @Override
    public int insert(Article record) {
        int insert = articleMapper.insert(record);
        return insert;
    }

    /**
     * 根据资讯主键Id删除资讯文章
     * @param id
     * @return
     */
    @Override
    public int deleteByPrimaryKey(Integer id) {
        int result = articleMapper.deleteByPrimaryKey(id);
        return result;
    }

    @Override
    public List<Article> selectAllInfo(Article article) {
        List<Article> articles = articleMapper.selectAllInfo(article);
        if (null != articles) {
            return articles;
        }else {
            return null;
        }
    }

    @Override
    public int updateByPrimaryKeySelective(Article record) {
        int result = articleMapper.updateByPrimaryKeySelective(record);
        return result;
    }
}
