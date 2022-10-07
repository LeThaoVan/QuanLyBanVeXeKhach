/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uav.formatter;

import com.uav.pojo.User;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author pc
 */
public class UserFormatter implements Formatter<User>{

    @Override
    public String print(User t, Locale locale) {
        return String.valueOf(t.getId());   
    }

    @Override
    public User parse(String id, Locale locale) throws ParseException {
        User c = new User();
        c.setId(Integer.parseInt(id));
        
        return c;   }
    
}
