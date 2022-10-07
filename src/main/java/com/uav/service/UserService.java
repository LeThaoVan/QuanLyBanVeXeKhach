/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.uav.service;

import com.uav.pojo.User;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author pc
 */
public interface UserService extends UserDetailsService {
    List<User> getUsers();
    
    //boolean addUser(User user);
    List<User> getUser (String username);
    boolean deleteUsers(int id);
    boolean updateUser(int id, String newrode);
}
