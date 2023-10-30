/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nnt.controllers;

import com.nnt.pojo.Binhluan;
import com.nnt.pojo.Tintuc;
import com.nnt.service.BinhluanService;
import com.nnt.service.ThongkeService;
import com.nnt.service.TintucService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Admin
 */
@RestController
@RequestMapping("/api")
public class ApiTintucController {

    @Autowired
    private TintucService tintucService;
    @Autowired
    private BinhluanService binhluanService;
    @Autowired
    private ThongkeService thongkeService;

    @DeleteMapping("/tintucs/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void xoa(@PathVariable(value = "id") int id) {
        this.tintucService.xoaTinTuc(id);
    }

    @GetMapping("/tintucs")
    @CrossOrigin
    public ResponseEntity<List<Tintuc>> list(@RequestParam Map<String, String> params) {
        return new ResponseEntity<>(this.tintucService.getTintuc(params), HttpStatus.OK);
    }

    @RequestMapping(path = "/tintucs/{tintucId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public ResponseEntity<Tintuc> chitiet(@PathVariable(value = "tintucId") int id) {
        return new ResponseEntity<>(this.tintucService.getTintucBangId(id), HttpStatus.OK);
    }

    @GetMapping("/tintucs/{tintucId}/binhluans/")
    @CrossOrigin
    public ResponseEntity<List<Binhluan>> listComments(@PathVariable(value = "tintucId") int id) {
        return new ResponseEntity<>(this.binhluanService.getBinhluans(id), HttpStatus.OK);
    }

    @PostMapping(path = "/binhluans/", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public ResponseEntity<Binhluan> addBinhluan(@RequestBody Binhluan binhluan) {
        Binhluan b = this.binhluanService.addBinhluan(binhluan);

        return new ResponseEntity<>(b, HttpStatus.CREATED);
    }

    @GetMapping("/thongke/")
    public List<Object[]> demTintucTheoDanhmuc(@RequestParam Map<String, String> params) {
        return thongkeService.demTintucTheoDanhmuc(params);
    }
}
