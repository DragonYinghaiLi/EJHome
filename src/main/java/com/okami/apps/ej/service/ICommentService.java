package com.okami.apps.ej.service;

import com.okami.apps.ej.bean.Comment;

import java.util.List;

public interface ICommentService {
    List<Comment> findAll();
    Comment findById(long id);
    List<Comment> query(Comment comment);
    void deleteById(long id) throws Exception;
    void saveOrUpdate(Comment comment) throws Exception;
    void batchDelete(long[] ids) throws Exception;
}
