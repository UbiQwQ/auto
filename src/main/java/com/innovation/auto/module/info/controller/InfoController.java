package com.innovation.auto.module.info.controller;

import com.innovation.auto.entity.Article;
import com.innovation.auto.model.APIResult;
import com.innovation.auto.module.info.service.ArticleService;
import com.innovation.auto.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
    public APIResult login() throws ParseException {

        APIResult apiResult = new APIResult();
        apiResult.setMsg("query successfully...");
        apiResult.setStatus(Constants.SUCCESS);

        List<Article> articles = articleService.selectAllInfo();
        if (null != articles){
            apiResult.setStatus(Constants.SUCCESS);
            apiResult.setRes(articles);
            return apiResult;
        }else {
            apiResult.setMsg("query failed...");
            apiResult.setStatus(Constants.ERROR);
            return apiResult;
        }
    }
}
