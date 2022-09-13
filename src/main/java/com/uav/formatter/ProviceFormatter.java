/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uav.formatter;

import com.uav.pojo.Province;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author pc
 */
public class ProviceFormatter implements Formatter<Province> {

    @Override
    public String print(Province t, Locale locale) {
        return String.valueOf(t.getId());
    }

    @Override
    public Province parse(String string, Locale locale) throws ParseException {
        Province c = new Province();
        c.setId(Integer.parseInt(string));

        return c;
    }
}


