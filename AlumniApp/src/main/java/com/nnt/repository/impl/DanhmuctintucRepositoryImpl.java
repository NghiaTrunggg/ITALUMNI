/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nnt.repository.impl;

import com.nnt.pojo.Danhmuctintuc;
import com.nnt.repository.DanhmuctintucRepository;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Admin
 */
@Repository
@Transactional
public class DanhmuctintucRepositoryImpl implements DanhmuctintucRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Danhmuctintuc> getDanhmucs() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("FROM Danhmuctintuc");
        
        return q.getResultList();
    }

    @Override
    public Danhmuctintuc getDanhmucById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(Danhmuctintuc.class, id);
    }

}
