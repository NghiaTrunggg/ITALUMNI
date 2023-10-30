/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nnt.controllers;

import com.nnt.pojo.Danhmuctintuc;
import com.nnt.service.DanhmuctintucService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Admin
 */
@RestController
@RequestMapping("/api")
public class ApiDanhmuctintucController {
    @Autowired
    private DanhmuctintucService danhmuctintucService;
    
    @GetMapping("/danhmuctintucs")
    @CrossOrigin
    public ResponseEntity<List<Danhmuctintuc>> list() {
        return new ResponseEntity<>(this.danhmuctintucService.getDanhmucs(), HttpStatus.OK);
    };
}
