/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.nnt.hibernate;

import com.nnt.pojo.Danhmuctintuc;
import com.nnt.repository.ThongkeRepository;
import com.nnt.repository.TintucRepository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import org.hibernate.Session;

/**
 *
 * @author Admin
 */
public class Hibernate {

    public static void main(String[] args) {
//        ThongkeRepository t = new ThongkeRepository();
//        t.tkTintucTheoDanhmuc().forEach(o -> System.out.printf("%d - %s - %d\n", o[0], o[1], o[2]));


//        Map<String, String> params = new HashMap<>();
//        params.put("danhmucId", "3");
//        
//        TintucRepository tin = new TintucRepository();
//        tin.getTintuc(params).forEach(t -> System.out.printf("%d - %s\n", t.getId(), t.getTen()));

          
          Map<String, String> params = new HashMap<>();
          params.put("danhmucId", "1");
          TintucRepository tin = new TintucRepository();
          tin.getTintuc(params).forEach(t -> System.out.printf("%d - %s\n", t.getId(), t.getTen()));
    }
}
