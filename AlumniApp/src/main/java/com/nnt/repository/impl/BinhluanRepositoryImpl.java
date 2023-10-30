/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nnt.repository.impl;

import com.nnt.pojo.Binhluan;
import com.nnt.repository.BinhluanRepository;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.boot.spi.SessionFactoryBuilderFactory;
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
public class BinhluanRepositoryImpl implements BinhluanRepository{
    @Autowired
    private LocalSessionFactoryBean factory;

    
    @Override
    public List<Binhluan> getBinhluans(int tintucId) {
        Session s = this.factory.getObject().getCurrentSession();
//        Query q = s.createQuery("From Binhluan Where tintuc.tintucId=:id");
        Query q = s.createQuery("FROM Binhluan b WHERE b.tintucId.id = :id");
        q.setParameter("id", tintucId);
        
        return q.getResultList();
    }

    @Override
    public Binhluan addBinhluan(Binhluan b) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            s.save(b);
            return b;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
}
