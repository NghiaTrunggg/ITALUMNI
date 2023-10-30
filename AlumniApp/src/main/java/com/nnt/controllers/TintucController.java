/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nnt.controllers;

import com.nnt.pojo.Tintuc;
import com.nnt.service.TintucService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Admin
 */
@Controller
public class TintucController {

    @Autowired
    private TintucService tintucService;

    @GetMapping("/tintucs")
    public String list(Model model) {
        model.addAttribute("tintuc", new Tintuc());
        return "tintucs";
    }
    
    @GetMapping("/tintucs/{id}")
    public String update(Model model, @PathVariable(value = "id") int id)  {
        model.addAttribute("tintuc", this.tintucService.getTintucBangId(id));
        System.out.println("ID " + id);
        return "tintucs";
    }

    @PostMapping("/tintucs")
    public String them(@ModelAttribute(value = "tintuc") @Valid Tintuc t, BindingResult rs) {
        if (!rs.hasErrors()) {
            if (tintucService.themHoacSuaTintuc(t) == true) {
                return "redirect:/";
            }
        }

        return "tintucs"; 
    }
}
