/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uav.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.uav.pojo.User;
import com.uav.repository.UserRepository;
import com.uav.service.UserService;
import com.uav.service.UserService;
import java.io.IOException;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author pc
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Cloudinary cloudinary;

//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public List<User> getUsers() {
        return this.userRepository.getUsers();
    }

//    @Override
//    public boolean addUser(User user) {
//
//        try {
//            String pass = user.getPass();
//            user.setPass(this.passwordEncoder.encode(pass));
//            user.setRole(User.USER);
//            user.setCreatedAt(new Date());
//
//            Map r = this.cloudinary.uploader().upload(user.getFile().getBytes(),
//                    ObjectUtils.asMap("resource_url", "auto"));
//            user.setAvatar((String) r.get("secure_url"));
//
//        } catch (IOException ex) {
//            ex.printStackTrace();
//            System.out.println("==================" + ex.getMessage());
//            System.out.println("==================" + ex.getMessage());
//            System.out.println("==================" + ex.getMessage());
//        }

   //     return this.userRepository.addUser(user);
 //   }

    @Override
    public List<User> getUser(String username) {
        return this.userRepository.getUser(username);
    }

   
    @Override
    public boolean deleteUsers(int id) {
        return this.userRepository.deleteUsers(id);
    }

    @Override
    public boolean updateUser(int id, String newrode) {
       return this.userRepository.updateUser(id, newrode);
    }

    @Override
    public UserDetails loadUserByUsername(String string) throws UsernameNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
