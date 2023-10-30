/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nnt.repository.impl;

import com.nnt.pojo.Nguoidung;
import com.nnt.repository.NguoidungRepository;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Admin
 */
@Repository
@Transactional
public class NguoidungRepositoryImpl implements NguoidungRepository {

    @Autowired
    private LocalSessionFactoryBean factory;
    @Autowired
    private BCryptPasswordEncoder passEncoder;

    @Override
    public Nguoidung getNguoidungByTendn(String tendn) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Nguoidung> q = b.createQuery(Nguoidung.class);
        Root root = q.from(Nguoidung.class);
        q = q.select(root);

        if (!tendn.isEmpty()) {
            Predicate p = b.equal(root.get("tendn").as(String.class), tendn.trim());
            q = q.where(p);
        }
//        q.where(b.equal(root.get("userUsername"), username));
        Query query = s.createQuery(q);
        return (Nguoidung) query.getSingleResult();
    }

    @Override
    public boolean authNguoidung(String tendn, String matkhau) {
        Nguoidung n = this.getNguoidungByTendn(tendn);

        return this.passEncoder.matches(matkhau, n.getMatkhau());
    }

    @Override
    public Nguoidung addNguoidung(Nguoidung n) {
        Session s = this.factory.getObject().getCurrentSession();
        s.save(n);

        return n;
    }

    @Override
    public Nguoidung getUserByUsername(String tendn) {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("FROM Nguoidung WHERE tendn=:un");
        q.setParameter("un", tendn);
        return (Nguoidung) q.getSingleResult();
    }

}
