/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nnt.service;

import com.nnt.pojo.Tintuc;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Admin
 */
public interface TintucService {
    List<Tintuc> getTintuc(Map<String, String> params);
    int demTintuc();
    boolean themHoacSuaTintuc(Tintuc t);
    Tintuc getTintucBangId(int id);
    boolean xoaTinTuc(int id);
}
