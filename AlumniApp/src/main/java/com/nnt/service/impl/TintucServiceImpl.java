/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nnt.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.nnt.pojo.Tintuc;
import com.nnt.repository.TintucRepository;
import com.nnt.service.TintucService;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Admin
 */
@Service
public class TintucServiceImpl implements TintucService {

    @Autowired
    private TintucRepository tintucRepo;
    @Autowired
    private Cloudinary cloudinary;

    @Override
    public List<Tintuc> getTintuc(Map<String, String> params) {
        return this.tintucRepo.getTintuc(params);
    }

    @Override
    public int demTintuc() {
        return this.tintucRepo.demTintuc();
        
    }

    @Override
    public boolean themHoacSuaTintuc(Tintuc t) {
        if (!t.getFile().isEmpty()) {
            try {
                Map res = this.cloudinary.uploader().upload(t.getFile().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
                t.setHinhanh(res.get("secure_url").toString());
            } catch (IOException ex) {
                Logger.getLogger(TintucServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return this.tintucRepo.themHoacSuaTintuc(t);
    }

    @Override
    public Tintuc getTintucBangId(int id) {
        return this.tintucRepo.getTintucBangId(id);
    }

    @Override
    public boolean xoaTinTuc(int id) {
        return this.tintucRepo.xoaTinTuc(id);
    }
}
