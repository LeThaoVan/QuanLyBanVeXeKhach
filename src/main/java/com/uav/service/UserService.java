/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.uav.service;

import com.uav.pojo.Users;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author pc
 */
public interface UserService extends UserDetailsService {
    List<Users> getUsers();
    
    boolean addUser(Users user);
    List<Users> getUser (String username);
    boolean deleteUsers(int id);
    boolean updateUser(int id, String newrode);
}
