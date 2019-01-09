package com.innovation.auto.mapper;

import com.innovation.auto.entity.Comment;

import java.util.List;

public interface CommentMapper {

    /**
     * 根据CommentID删除评论
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);

    /**
     * 根据用户id查询评论
     * @param comment
     * @return
     */
    List<Comment> selectMyComment(Comment comment);

    /**
     * 根据文章id查询评论
     * @param comment
     * @return
     */
    List<Comment> selectInfoComment(Comment comment);


}