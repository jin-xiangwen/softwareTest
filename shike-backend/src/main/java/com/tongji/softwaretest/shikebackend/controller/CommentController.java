package com.tongji.softwaretest.shikebackend.controller;

import com.tongji.softwaretest.shikebackend.entity.Comment;
import com.tongji.softwaretest.shikebackend.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/addcomment")
    private Map<String,Object> addComment(@RequestBody Comment comment){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", commentService.addComment(comment));
        return modelMap;
    }

    @GetMapping("/listcomment")
    private Map<String,Object> listComment(Integer storeId){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        List<Comment> list = commentService.getCommentList(storeId);
        modelMap.put("data", list);
        return modelMap;
    }
}
