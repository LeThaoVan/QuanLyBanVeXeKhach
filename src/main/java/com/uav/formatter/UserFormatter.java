/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uav.formatter;

import com.uav.pojo.Users;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author pc
 */
public class UserFormatter implements Formatter<Users>{

    @Override
    public String print(Users t, Locale locale) {
        return String.valueOf(t.getUserid());   
    }

    @Override
    public Users parse(String id, Locale locale) throws ParseException {
        Users c = new Users();
        c.setUserid(Integer.parseInt(id));
        
        return c;   }
    
}
