/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uav.controllers;

import com.uav.pojo.Users;
import com.uav.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
/**
 *
 * @author pc
 */
@RestController
@RequestMapping("/api")
public class ApiUsersControllers {
    
    
    @Autowired
    private UserService usersService;
    
     @GetMapping("/users")
    public ResponseEntity<List<Users>> list() {
        return new ResponseEntity<>(this.usersService.getUsers(), HttpStatus.OK);
    }
    
    @DeleteMapping("/users/{usersid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value = "usersid") int id) {
        this.usersService.deleteUsers(id);
    }
}
