/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nnt.controllers;

import com.nnt.pojo.Nguoidung;
import com.nnt.service.NguoidungService;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Admin
 */
@Controller
public class NguoidungController {
     @Autowired
    private NguoidungService userDetailsService;
//    @Autowired
//    private WebAppValidator userValidator;
    
//    @InitBinder
//    public void initBinder(WebDataBinder binder) {
//        binder.setValidator(userValidator);
//    }
     
     
    
    @GetMapping("/login")
    public String login() {
        return "login";
    }
    
    @GetMapping("/dangky")
    public String registerView(Model model) {
        model.addAttribute("nguoidung", new Nguoidung());
        return "dangky";
    }
    
    @PostMapping("/dangky")
    public String register(Model model, @RequestParam Map<String, String> params, @ModelAttribute(value = "nguoidung") Nguoidung nguoidung,
            @RequestPart(required = false) MultipartFile file) {
       
        Nguoidung newNguoidung = userDetailsService.addNguoidung(params, file);
        if(newNguoidung != null)
            return "redirect:/login";
        else
            return "dangky";
    }
}
