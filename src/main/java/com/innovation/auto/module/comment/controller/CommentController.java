package com.innovation.auto.module.comment.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.innovation.auto.entity.Comment;
import com.innovation.auto.model.APIResult;
import com.innovation.auto.module.comment.service.CommentService;
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
 * @Date: 2019/1/6 21:21
 * @email lt1550919167@163.com
 * @QQ 1550919167
 * @Description:
 */
@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    /**
     * 查询我的评论
     * @param userId
     * @param pageNum
     * @param pageSize
     * @return
     * @throws ParseException
     */
    @GetMapping("/comment/queryMyComment")
    public APIResult info(@RequestParam(value = "userId",required = false) Integer userId,
                          @RequestParam(value = "pageNum", required = false, defaultValue="1") Integer pageNum,
                          @RequestParam(value = "pageSize", required = false, defaultValue="10") Integer pageSize) throws ParseException {

        APIResult apiResult = new APIResult();
        apiResult.setMsg("query successfully...");
        apiResult.setStatus(Constants.SUCCESS);
        //根据资讯标题查询
        Comment comment = new Comment();
        if (null != userId){
            comment.setUserId(userId);
        }

        PageHelper.startPage(pageNum, pageSize);
        List<Comment> comments = commentService.selectMyComment(comment);
        PageInfo<Comment> pageInfo = new PageInfo<Comment>(comments);

        if (null != pageInfo){
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
     * 删除评论
     * @param id
     * @return
     */
    @PostMapping("/comment/deleteComment")
    public APIResult info(@RequestParam(value = "id",required = false) Integer id) {

        APIResult apiResult = new APIResult();
        apiResult.setMsg("delete successfully...");
        apiResult.setStatus(Constants.SUCCESS);
        //根据资讯标题查询
        int result = commentService.deleteByPrimaryKey(id);

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
