/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nnt.service;

import com.nnt.pojo.Danhmuctintuc;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface DanhmuctintucService {
    List<Danhmuctintuc> getDanhmucs();
    Danhmuctintuc getDanhmucById(int id);
}
