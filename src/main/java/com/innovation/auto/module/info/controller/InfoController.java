package com.innovation.auto.module.info.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.innovation.auto.entity.Article;
import com.innovation.auto.model.APIResult;
import com.innovation.auto.module.info.service.ArticleService;
import com.innovation.auto.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;

/**
 * @Auther: carver
 * @Date: 2019/1/4 20:06
 * @email lt1550919167@163.com
 * @QQ 1550919167
 * @Description:
 */
@RestController
public class InfoController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/info")
    public APIResult info(@RequestParam(value = "title",required = false) String title,
                          @RequestParam(value = "userId",required = false) Integer userId,
                          @RequestParam(value = "pageNum", required = false, defaultValue="1") Integer pageNum,
                          @RequestParam(value = "pageSize", required = false, defaultValue="10") Integer pageSize) throws ParseException {

        APIResult apiResult = new APIResult();
        apiResult.setMsg("query successfully...");
        apiResult.setStatus(Constants.SUCCESS);
        //根据资讯标题查询
        Article article = new Article();
        if (null != title) {
            article.setTitle(title);
        }
        if (null != userId){
            article.setUserId(userId);
        }

        PageHelper.startPage(pageNum, pageSize);
        List<Article> articles = articleService.selectAllInfo(article);
        PageInfo<Article> pageInfo = new PageInfo<Article>(articles);

        if (null != articles){
            apiResult.setStatus(Constants.SUCCESS);
            apiResult.setRes(pageInfo);
            return apiResult;
        }else {
            apiResult.setMsg("query failed...");
            apiResult.setStatus(Constants.ERROR);
            return apiResult;
        }
    }

    @PostMapping("/info/deleteInfo")
    public APIResult info(@RequestParam(value = "id",required = false) Integer id) {

        APIResult apiResult = new APIResult();
        apiResult.setMsg("delete successfully...");
        apiResult.setStatus(Constants.SUCCESS);
        //根据资讯标题查询
        int result = articleService.deleteByPrimaryKey(id);

        if (result == 1) {
            apiResult.setStatus(Constants.SUCCESS);
            return apiResult;
        }else {
            apiResult.setMsg("delete failed...");
            apiResult.setStatus(Constants.ERROR);
            return apiResult;
        }
    }
}
