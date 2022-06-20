package com.tongji.softwaretest.shikebackend.service;

import com.tongji.softwaretest.shikebackend.entity.Comment;

import java.util.List;

public interface CommentService {

    List<Comment> getCommentList(int storeId);

    Comment getCommentById(String commentId);

    boolean addComment(Comment comment);
}
