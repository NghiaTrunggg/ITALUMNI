/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nnt.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.nnt.pojo.Nguoidung;
import com.nnt.repository.NguoidungRepository;
import com.nnt.service.NguoidungService;
import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Admin
 */
@Service("userDetailsService")
public class NguoidungServiceImpl implements NguoidungService {

    @Autowired
    private NguoidungRepository nguoidungRepo;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private Cloudinary cloudinary;

    @Override
    public UserDetails loadUserByUsername(String tendn) throws UsernameNotFoundException {
        Nguoidung n = this.getNguoidungByTendn(tendn);
        if (n == null) {
            throw new UsernameNotFoundException("Invalid");
        }
        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(n.getPhanquyen()));
        return new org.springframework.security.core.userdetails.User(
                n.getTendn(), n.getMatkhau(), authorities);
    }

    @Override
    public Nguoidung getNguoidungByTendn(String tendn) {
        return this.nguoidungRepo.getNguoidungByTendn(tendn);
    }

    @Override
    public boolean authNguoidung(String tendn, String matkhau) {
        return this.nguoidungRepo.authNguoidung(tendn, matkhau);
    }

    @Override
    public Nguoidung addNguoidung(Map<String, String> params, MultipartFile hinhdaidien) {
        Nguoidung n = new Nguoidung();
        n.setHo(params.get("ho"));
        n.setTen(params.get("ten"));
        n.setNienkhoa(params.get("nienkhoa"));
        n.setTendn(params.get("tendn"));
        n.setMatkhau(this.passwordEncoder.encode(params.get("matkhau")));
        n.setPhanquyen("ROLE_ADMIN");
        if (!hinhdaidien.isEmpty()) {
            try {
                Map res = this.cloudinary.uploader().upload(hinhdaidien.getBytes(), 
                        ObjectUtils.asMap("resource_type", "auto"));
                n.setHinhdaidien(res.get("secure_url").toString());
            } catch (IOException ex) {
                Logger.getLogger(NguoidungServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        this.nguoidungRepo.addNguoidung(n);
        return n;
    }
}
