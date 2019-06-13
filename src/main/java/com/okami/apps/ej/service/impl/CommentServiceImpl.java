package com.okami.apps.ej.service.impl;

import com.okami.apps.ej.bean.Comment;
import com.okami.apps.ej.bean.CommentExample;
import com.okami.apps.ej.dao.CommentMapper;
import com.okami.apps.ej.service.ICommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class CommentServiceImpl implements ICommentService {
    @Resource
    private CommentMapper commentMapper;

    @Override
    public List<Comment> findAll() {
        CommentExample example=new CommentExample();
        return commentMapper.selectByExample(example);
    }

    @Override
    public void deleteById(long id) throws Exception {
        Comment comment=commentMapper.selectByPrimaryKey(id);
        if(comment==null){
            throw  new Exception("要删除的评论不存在");
        }else{
            commentMapper.deleteByPrimaryKey(id);
        }
    }

}