/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uav.service.impl;

import com.uav.pojo.Comment;
import com.uav.repository.CommentRepository;
import com.uav.service.CommentService;
import java.security.Principal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Service
public class CommentServiceImpl implements CommentService{
    
    @Autowired
    private CommentRepository commentRepository;


    @Override
    public Comment addComment(String content, int routeBusesId, int userId) {
       return this.commentRepository.addComment(content,routeBusesId, userId);
    }

    @Override
    public List<Comment> getCommentsByRouteBusesId(int routeBusesId,int page) {
       return this.commentRepository.getCommentsByRouteBusesId(routeBusesId, page);
    }

    @Override
    public long countComment(int routeBusId) {
        return this.commentRepository.countComment(routeBusId);
    }
    
}
