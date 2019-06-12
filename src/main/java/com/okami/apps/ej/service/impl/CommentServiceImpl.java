package com.okami.apps.ej.service.impl;

import com.okami.apps.ej.dao.CommentMapper;
import com.okami.apps.ej.service.ICommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class CommentServiceImpl implements ICommentService {

    @Resource
    private CommentMapper commentMapper;

}
