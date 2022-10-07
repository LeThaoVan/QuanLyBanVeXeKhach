/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uav.formatter;

import com.uav.pojo.TypeOfBus;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author pc
 */
public class TypeOfBusFormatter implements Formatter<TypeOfBus>{
    
    @Override
    public String print(TypeOfBus t, Locale locale) {
        return String.valueOf(t.getId());
    }

    @Override
    public TypeOfBus parse(String id, Locale locale) throws ParseException {
        TypeOfBus c = new TypeOfBus();
        c.setId(Integer.parseInt(id));
        
        return c;
    }
}
