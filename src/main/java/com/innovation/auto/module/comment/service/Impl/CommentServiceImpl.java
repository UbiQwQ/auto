package com.innovation.auto.module.comment.service.Impl;

import com.innovation.auto.entity.Comment;
import com.innovation.auto.mapper.CommentMapper;
import com.innovation.auto.module.comment.service.CommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: carver
 * @Date: 2019/1/6 21:30
 * @email lt1550919167@163.com
 * @QQ 1550919167
 * @Description:
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Resource
    private CommentMapper commentMapper;


    @Override
    public int insertSelective(Comment record) {
        int result = commentMapper.insertSelective(record);
        return result;
    }

    /**
     * 根据commentId删除评论
     * @param id
     * @return
     */
    @Override
    public int deleteByPrimaryKey(Integer id) {
        int result = commentMapper.deleteByPrimaryKey(id);
        return result;
    }

    /**
     * 查询我的评论
     * @param comment
     * @return
     */
    @Override
    public List<Comment> selectMyComment(Comment comment) {
        List<Comment> comments = commentMapper.selectMyComment(comment);

        return comments;
    }

    @Override
    public List<Comment> selectInfoComment(Comment comment) {
        List<Comment> comments = commentMapper.selectInfoComment(comment);
        return comments;
    }
}
