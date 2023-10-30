/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nnt.controllers;

import com.nnt.service.DanhmuctintucService;
import com.nnt.service.TintucService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Admin
 */
@Controller
@ControllerAdvice
@PropertySource("classpath:configs.properties")
public class IndexController {

    @Autowired
    private TintucService tintucService;
    @Autowired
    private DanhmuctintucService danhmucService;
    @Autowired
    private Environment env;

    @ModelAttribute
    public void commonAttr(Model model) {
        model.addAttribute("danhmuctintuc", this.danhmucService.getDanhmucs());
    }

    @RequestMapping("/")
    public String index(Model model, @RequestParam Map<String, String> params) {
        model.addAttribute("tintuc", this.tintucService.getTintuc(params));

        int pageSize = Integer.parseInt(this.env.getProperty("PAGE_SIZE"));
        int dem = this.tintucService.demTintuc();
        model.addAttribute("demTT", Math.ceil(dem * 1.0 / pageSize));
        System.out.println(this.tintucService.getTintuc(params));
        return "index";
    }

    
}
