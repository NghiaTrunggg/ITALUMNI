/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nnt.service.impl;

import com.nnt.pojo.Binhluan;
import com.nnt.pojo.Nguoidung;
import com.nnt.pojo.Tintuc;
import com.nnt.repository.BinhluanRepository;
import com.nnt.repository.NguoidungRepository;
import com.nnt.repository.TintucRepository;
import com.nnt.service.BinhluanService;
import java.util.List;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class BinhluanServiceImpl implements BinhluanService {

    @Autowired
    private BinhluanRepository binhluanRepo;
    @Autowired
    private NguoidungRepository nguoidungRepo;
    @Autowired
    private TintucRepository tintucRepository;

    @Override
    public List<Binhluan> getBinhluans(int tintucId) {
        return this.binhluanRepo.getBinhluans(tintucId);
    }

    @Override
    public Binhluan addBinhluan(Binhluan b) {
        b.setNgay(new Date());

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Nguoidung n = this.nguoidungRepo.getNguoidungByTendn(authentication.getName());
        b.setNguoidungId(n);
        Integer tintucId = b.getTintucId().getId();
        if (tintucId != null) {
            Tintuc tintuc = this.tintucRepository.getTintucBangId(tintucId);
            if (tintuc != null) {
                b.setTintucId(tintuc);
                return this.binhluanRepo.addBinhluan(b);
            }
        }
        return null;
        // hay là có khi nào do database t làm khóa chính khóa ngoại bị sai không
    }

}
