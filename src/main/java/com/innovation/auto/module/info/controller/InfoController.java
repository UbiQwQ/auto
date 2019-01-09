package com.innovation.auto.module.info.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.innovation.auto.entity.Article;
import com.innovation.auto.model.APIResult;
import com.innovation.auto.module.info.service.ArticleService;
import com.innovation.auto.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @Auther: carver
 * @Date: 2019/1/4 20:06
 * @email lt1550919167@163.com
 * @QQ 1550919167
 * @Description:
 */
@RestController
public class InfoController {

    @Value("${IMAGEHTTP}")
    private String imageHttp;

    @Autowired
    private ArticleService articleService;

    /**
     * 查询资讯
     * @param infoId
     * @param title
     * @param userId
     * @param pageNum
     * @param pageSize
     * @return
     * @throws ParseException
     */
    @GetMapping("/info")
    public APIResult info(@RequestParam(value = "infoId",required = false) Integer infoId,
                          @RequestParam(value = "title",required = false) String title,
                          @RequestParam(value = "userId",required = false) Integer userId,
                          @RequestParam(value = "pageNum", required = false, defaultValue="1") Integer pageNum,
                          @RequestParam(value = "pageSize", required = false, defaultValue="10") Integer pageSize) throws ParseException {

        APIResult apiResult = new APIResult();
        apiResult.setMsg("query successfully...");
        apiResult.setStatus(Constants.SUCCESS);

        //根据资讯标题查询
        Article article = new Article();
        if (null != infoId){
            article.setId(infoId);
        }
        if (null != title) {
            article.setTitle(title);
        }
        if (null != userId){
            article.setUserId(userId);
        }


        PageHelper.startPage(pageNum, pageSize);
        List<Article> articles = articleService.selectAllInfo(article);
        PageInfo<Article> pageInfo = new PageInfo<Article>(articles);

        if (null != infoId) {
            apiResult.setStatus(Constants.SUCCESS);
            apiResult.setRes(articles.get(0));
            return apiResult;
        }

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

    /**
     * 删除资讯
     * @param id
     * @return
     */
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

    /**
     * 发布资讯
     * @param id
     * @param title
     * @param content
     * @param image
     * @return
     * @throws IOException
     */
    @PostMapping("/info/insertInfo")
    public APIResult insertInfo(@RequestParam(value = "id",required = true) Integer id,
                                @RequestParam(value = "title",required = true) String title,
                                @RequestParam(value = "content",required = true) String content,
                                @RequestParam(value = "image",required = false) MultipartFile image) throws IOException {

        APIResult apiResult = new APIResult();
        apiResult.setMsg("insert successfully...");
        apiResult.setStatus(Constants.SUCCESS);

        if (id == null) {
            apiResult.setMsg("用户ID不能为空");
            apiResult.setStatus(Constants.ERROR2);
            return apiResult;
        }
        if (title == null) {
            apiResult.setMsg("资讯标题不能为空");
            apiResult.setStatus(Constants.ERROR2);
            return apiResult;
        }
        if (content == null) {
            apiResult.setMsg("资讯内容不能为空");
            apiResult.setStatus(Constants.ERROR2);
            return apiResult;
        }

        //拿到图片原始名称
        String orginFilename = image.getOriginalFilename();
        //图片存储路径
        String imagePath = "D:\\Nginx\\AutoImg\\";
        //UUID图片名称
        String imageFilename = UUID.randomUUID() + orginFilename.substring(orginFilename.lastIndexOf("."));
        //新的图片
        File newFile = new File(imagePath + imageFilename);
        //将内存中数据写入服务器磁盘
        image.transferTo(newFile);

        Article article = new Article();
        article.setTitle(title);
        article.setAgreeNum("0");
        article.setUserId(id);
        article.setClicks("0");
        article.setCreatedTime(new Date());
        article.setImage(imageHttp + imageFilename);
        article.setDisagreeNum("0");
        article.setTextBody(content);

        int result = articleService.insert(article);

        if (result == 1) {
            apiResult.setStatus(Constants.SUCCESS);
            return apiResult;
        }else {
            apiResult.setMsg("insert failed...");
            apiResult.setStatus(Constants.ERROR);
            return apiResult;
        }
    }

    /**
     * 资讯点击次数
     * @param id
     * @return
     * @throws IOException
     */
    @PostMapping("/info/clickInfo")
    public APIResult clickInfo(@RequestParam(value = "infoId",required = true) Integer id) throws IOException {

        APIResult apiResult = new APIResult();
        apiResult.setMsg("update successfully...");
        apiResult.setStatus(Constants.SUCCESS);

        if (id == null) {
            apiResult.setMsg("用户ID不能为空");
            apiResult.setStatus(Constants.ERROR2);
            return apiResult;
        }

        Article article = articleService.selectByPrimaryKey(id);

        String clicks = article.getClicks();
        int clicksInt = Integer.parseInt(clicks) + 1;
        article.setClicks(clicksInt+"");

        int result = articleService.updateByPrimaryKeySelective(article);
        if (result == 1) {
            apiResult.setStatus(Constants.SUCCESS);
            return apiResult;
        }else {
            apiResult.setMsg("update failed...");
            apiResult.setStatus(Constants.ERROR);
            return apiResult;
        }
    }
}
