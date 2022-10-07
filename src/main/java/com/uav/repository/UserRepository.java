/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.uav.repository;

import com.uav.pojo.User;
import java.util.List;

/**
 *
 * @author pc
 */
public interface UserRepository {
    List<User> getUsers();
//    boolean addUser(User user);
    List<User> getUser (String username);
    boolean deleteUsers(int id);
    boolean updateUser(int id, String newrode);
}
