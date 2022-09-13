/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.uav.service;

import com.uav.pojo.Comment;
import java.security.Principal;
import java.util.List;

/**
 *
 * @author HP
 */
public interface CommentService {
    List<Comment> getCommentsByRouteBusesId(int routeBusesId, int page);
    Comment addComment(String content, int routeBusesId,int userId);
    long countComment(int routeBusId);
}
