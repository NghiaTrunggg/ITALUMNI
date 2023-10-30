/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nnt.service.impl;

import com.nnt.repository.ThongkeRepository;
import com.nnt.service.ThongkeService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class ThongkeServiceImpl implements ThongkeService {

    @Autowired
    private ThongkeRepository thongkeRepository;

    @Override
    public List<Object[]> demTintucTheoDanhmuc(Map<String, String> params) {
        List<Object[]> dem = this.thongkeRepository.demTintucTheoDanhmuc(params);
        return dem;
    }
}
