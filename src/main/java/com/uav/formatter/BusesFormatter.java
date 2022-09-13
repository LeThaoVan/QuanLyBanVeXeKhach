/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uav.formatter;

import com.uav.pojo.Buses;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author pc
 */
public class BusesFormatter implements Formatter<Buses> {

    @Override
    public String print(Buses t, Locale locale) {
        return String.valueOf(t.getBid());
    }

    @Override
    public Buses parse(String string, Locale locale) throws ParseException {
        Buses c = new Buses();
        c.setBid(Integer.parseInt(string));

        return c;
    }

}
