/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nnt.formatters;

import com.nnt.pojo.Danhmuctintuc;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author Admin
 */
public class DanhmuctintucFormatter implements Formatter<Danhmuctintuc>{

    @Override
    public String print(Danhmuctintuc danhmuc, Locale locale) {
        return String.valueOf(danhmuc.getId());
    }

    @Override
    public Danhmuctintuc parse(String danhmucId, Locale locale) throws ParseException {
        int id = Integer.parseInt(danhmucId);
        return new Danhmuctintuc(id);
    }
    
}
