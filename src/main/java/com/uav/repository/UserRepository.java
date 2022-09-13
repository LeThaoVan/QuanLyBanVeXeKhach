/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.uav.repository;

import com.uav.pojo.Users;
import java.util.List;

/**
 *
 * @author pc
 */
public interface UserRepository {
    List<Users> getUsers();
    
    boolean addUser(Users user);
    List<Users> getUser (String username);
    boolean deleteUsers(int id);
    boolean updateUser(int id, String newrode);
}
