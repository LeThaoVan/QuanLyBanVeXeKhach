/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uav.controllers;

import com.uav.pojo.Comment;
import com.uav.service.CommentService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController //gọi băng ajax
public class ApiCommentController {
    
    @Autowired
    private CommentService commentService;  
        
    @PostMapping(path ="/api/addcomment", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<Comment> addComment(@RequestBody Map<String, String> params
           ){
        try{
             String content = params.get("content");
             int routeBusesId = Integer.parseInt(params.get("routeBusesId"));
             int userId = Integer.parseInt(params.get("userId"));
             Comment c = this.commentService.addComment(content, routeBusesId, userId);
             return new ResponseEntity<>(c, HttpStatus.CREATED);
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
       return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    
}
