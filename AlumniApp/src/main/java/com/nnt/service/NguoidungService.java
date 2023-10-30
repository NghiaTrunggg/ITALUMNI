/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nnt.service;

import com.nnt.pojo.Nguoidung;
import java.util.Map;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Admin
 */
public interface NguoidungService extends UserDetailsService{
    Nguoidung getNguoidungByTendn(String tendn);
    boolean authNguoidung(String tendn, String matkhau);
    Nguoidung addNguoidung(Map<String, String> params, MultipartFile hinhdaidien);
}
