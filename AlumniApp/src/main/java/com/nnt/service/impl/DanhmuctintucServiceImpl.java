/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nnt.service.impl;

import com.nnt.pojo.Danhmuctintuc;
import com.nnt.repository.DanhmuctintucRepository;
import com.nnt.service.DanhmuctintucService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class DanhmuctintucServiceImpl implements DanhmuctintucService{
    @Autowired
    private DanhmuctintucRepository danhmucRepo;
    
    @Override
    public List<Danhmuctintuc> getDanhmucs() {
        return this.danhmucRepo.getDanhmucs();
    }
    
    @Override
    public Danhmuctintuc getDanhmucById(int id) {
        return this.danhmucRepo.getDanhmucById(id);
    }

    
}
