/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nnt.service;

import com.nnt.pojo.Binhluan;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface BinhluanService {
    List<Binhluan> getBinhluans(int tintucId);
    Binhluan addBinhluan(Binhluan b);
}
