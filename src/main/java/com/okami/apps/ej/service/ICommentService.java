package com.okami.apps.ej.service;

import com.okami.apps.ej.bean.Comment;

import java.util.List;

public interface ICommentService {
    List<Comment> findAll();
    void deleteById(long id) throws Exception;
}
