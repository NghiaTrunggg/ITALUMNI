/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nnt.repository.impl;

import com.nnt.pojo.Danhmuctintuc;
import com.nnt.pojo.Tintuc;
import com.nnt.repository.ThongkeRepository;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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
public class ThongkeRepositoryImpl implements ThongkeRepository{
     @Autowired
    private LocalSessionFactoryBean factory;

    public List<Object[]> tkTintucTheoDanhmuc() {
        try (Session session = this.factory.getObject().getCurrentSession()) {
            CriteriaBuilder b = session.getCriteriaBuilder();
            CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
            Root rT = q.from(Tintuc.class);
            Root rD = q.from(Danhmuctintuc.class);
            
            q.multiselect(rD.get("id"), rD.get("ten"), b.count(rT.get("id")));
            
            q.where(b.equal(rT.get("danhmuctintucId"), rD.get("id")));
            q.groupBy(rD.get("id"));
            
            Query query = session.createQuery(q);
            return query.getResultList();
        }
    }
    
    
    @Override
    public List<Object[]> demTintucTheoDanhmuc(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
        Root rT = q.from(Tintuc.class);
        Root rD = q.from(Danhmuctintuc.class);

        q.multiselect(rD.get("id"), 
                rD.get("ten"), 
                b.function("MONTH", Integer.class, rT.get("ngaydang")),
                b.function("QUARTER", Integer.class, rT.get("ngaydang")),
                b.function("YEAR", Integer.class, rT.get("ngaydang")),
                b.count(rT.get("id")));
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(b.equal(rT.get("danhmuctintucId"), rD.get("id")));

        String years = params.get("years"); 
        if (years != null && !years.isEmpty()) {
            predicates.add(b.equal(b.function("YEAR", Integer.class, rT.get("ngaydang")), Integer.parseInt(years)));
        }

        String quarters = params.get("quarters");
        if (quarters != null && !quarters.isEmpty()) {
            if (years != null && !years.isEmpty()) {
                predicates.addAll(Arrays.asList(
                        b.equal(b.function("YEAR", Integer.class, rT.get("ngaydang")), Integer.parseInt(years)),
                        b.equal(b.function("QUARTER", Integer.class, rT.get("ngaydang")), Integer.parseInt(quarters))
                ));
            }
        }

        String months = params.get("months");
        if (months != null && !months.isEmpty()) {
            if (years != null && !years.isEmpty()) {
                predicates.addAll(Arrays.asList(
                        b.equal(b.function("YEAR", Integer.class, rT.get("ngaydang")), Integer.parseInt(years)),
                        b.equal(b.function("MONTH", Integer.class, rT.get("ngaydang")), Integer.parseInt(months))
                ));
            }
        }

        q.where(predicates.toArray(Predicate[]::new));
        q.groupBy(rD.get("id"), 
                b.function("MONTH", Integer.class, rT.get("ngaydang")),
                b.function("QUARTER", Integer.class, rT.get("ngaydang")),
                b.function("YEAR", Integer.class, rT.get("ngaydang"))
        );
        Query query = s.createQuery(q);
        return query.getResultList();
    }
}
