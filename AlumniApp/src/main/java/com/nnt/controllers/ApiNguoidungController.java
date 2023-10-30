/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nnt.controllers;

import com.nnt.components.JwtService;
import com.nnt.pojo.Nguoidung;
import com.nnt.service.NguoidungService;
import java.security.Principal;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Admin
 */
@RestController
@RequestMapping("/api")
public class ApiNguoidungController {
    @Autowired
    private JwtService jwtService;
    @Autowired
    private NguoidungService nguoidungService;

    @PostMapping("/login/")
    @CrossOrigin
    public ResponseEntity<String> login(@RequestBody Nguoidung nguoidung) {
        if (this.nguoidungService.authNguoidung(nguoidung.getTendn(), nguoidung.getMatkhau()) == true) {
            String token = this.jwtService.generateTokenLogin(nguoidung.getTendn());
            
            return new ResponseEntity<>(token, HttpStatus.OK);
        }

        return new ResponseEntity<>("error", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/test")
    @CrossOrigin(origins = {"127.0.0.1:5500"})
    public ResponseEntity<String> test(Principal pricipal) {
        return new ResponseEntity<>("SUCCESSFUL", HttpStatus.OK);
    }
    

    
    @PostMapping(path = "/nguoidung/", 
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE}, 
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @CrossOrigin
    public ResponseEntity<Nguoidung> addNguoidung(@RequestParam Map<String, String> params, @RequestPart MultipartFile hinhdaidien) {
        Nguoidung nguoidung = this.nguoidungService.addNguoidung(params, hinhdaidien);
        return new ResponseEntity<>(nguoidung, HttpStatus.CREATED);
    }
    
    @GetMapping(path = "/current-user/", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public ResponseEntity<Nguoidung> details(Principal nguoidung) {
        Nguoidung n = this.nguoidungService.getNguoidungByTendn(nguoidung.getName());
        return new ResponseEntity<>(n, HttpStatus.OK);
    }
}
