/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nnt.repository;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Admin
 */
public interface ThongkeRepository {
    List<Object[]> tkTintucTheoDanhmuc();
    List<Object[]> demTintucTheoDanhmuc(Map<String, String> params);
}
