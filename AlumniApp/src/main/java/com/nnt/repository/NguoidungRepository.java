/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nnt.repository;

import com.nnt.pojo.Nguoidung;

/**
 *
 * @author Admin
 */
public interface NguoidungRepository {
    Nguoidung getNguoidungByTendn(String tendn);
    boolean authNguoidung(String tendn, String matkhau);
    Nguoidung addNguoidung(Nguoidung nguoidung);
     
    Nguoidung getUserByUsername(String tendn);
}
