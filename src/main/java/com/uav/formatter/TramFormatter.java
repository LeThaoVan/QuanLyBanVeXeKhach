/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uav.formatter;

import com.uav.pojo.Tram;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author pc
 */
public class TramFormatter implements Formatter<Tram>{
    
    @Override
    public String print(Tram t, Locale locale) {
        return String.valueOf(t.getIdtram());
    }

    @Override
    public Tram parse(String id, Locale locale) throws ParseException {
        Tram c = new Tram();
        c.setIdtram(Integer.parseInt(id));
        
        return c;
    }
}
