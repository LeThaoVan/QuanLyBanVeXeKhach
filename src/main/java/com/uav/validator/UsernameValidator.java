/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uav.validator;

import com.uav.pojo.Users;
import com.uav.service.impl.UserServiceImpl;
import java.util.List;
import javassist.compiler.JvstCodeGen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author HP
 */
@Component
public class UsernameValidator implements Validator {
    
    
    @Autowired
    private UserServiceImpl userService;

    @Override
    public boolean supports(Class<?> clazz) {
        return Users.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Users user = (Users) target;
        List<Users> users = this.userService.getUsers();
        users.forEach(u->{
            if(u.getUsername().equals(user.getUsername())){
                errors.rejectValue("username", "Users.usernameUnique.errorMsg");
            }
            if(u.getEmail().equals(user.getEmail())){
                errors.rejectValue("email", "Users.emailUnique.errorMsg");
            }
            if(u.getSdt().equals(user.getSdt())){
                errors.rejectValue("sdt", "Users.SDTUnique.errorMsg");
            }
        });
        
    }
    
}
