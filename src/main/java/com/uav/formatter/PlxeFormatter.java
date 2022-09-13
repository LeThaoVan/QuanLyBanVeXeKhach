/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uav.formatter;

import com.uav.pojo.Plxe;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author pc
 */
public class PlxeFormatter implements Formatter<Plxe>{

    @Override
    public String print(Plxe t, Locale locale) {
        return String.valueOf(t.getLid());   
    }

    @Override
    public Plxe parse(String Lid, Locale locale) throws ParseException {
         Plxe c = new Plxe();
        c.setLid(Integer.parseInt(Lid));
        
        return c;    }
    
}
