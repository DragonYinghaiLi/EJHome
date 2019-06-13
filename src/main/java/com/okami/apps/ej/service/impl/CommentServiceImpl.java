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
        CommentExample example = new CommentExample();
        return commentMapper.selectByExample(example);
    }

    @Override
    public Comment findById(long id) {
        return commentMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Comment> query(Comment comment) {
        return commentMapper.query(comment);
    }

    @Override
    public void saveOrUpdate(Comment comment) throws Exception{
        if (comment.getId() == null) {
            commentMapper.insert(comment);
        } else {
            commentMapper.updateByPrimaryKey(comment);
        }
    }



    @Override
    public void deleteById(long id) throws Exception {
        Comment comment = commentMapper.selectByPrimaryKey(id);
        if (comment == null) {
            throw new Exception("要删除的用户不存在");
        } else {
            commentMapper.deleteByPrimaryKey(id);
        }

    }
    @Override
    public void batchDelete(long[] ids) throws Exception {

        for(long id :ids){
            commentMapper.deleteByPrimaryKey(id);
        }
    }

}
