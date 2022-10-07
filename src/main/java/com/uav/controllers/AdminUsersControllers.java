/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uav.controllers;

import com.uav.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author pc
 */
@Controller
@RequestMapping("/admin")
public class AdminUsersControllers {
     @Autowired
    private UserService usersService;

    @GetMapping("/users")
    public String list(Model model, @RequestParam(value = "newrode", defaultValue = "") String rode,
            @RequestParam(value = "idU", defaultValue = "0") int id) {

        this.usersService.updateUser(id, rode);
        return "admin-users";
    }

}
