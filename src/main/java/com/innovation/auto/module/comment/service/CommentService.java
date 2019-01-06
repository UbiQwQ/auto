package com.innovation.auto.module.comment.service;

import com.innovation.auto.entity.Comment;

import java.util.List;

/**
 * @Auther: carver
 * @Date: 2019/1/6 21:30
 * @email lt1550919167@163.com
 * @QQ 1550919167
 * @Description:
 */
public interface CommentService {

    /**
     * 根据CommentID删除评论
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 根据用户id查询评论
     * @param comment
     * @return
     */
    List<Comment> selectMyComment(Comment comment);
}
