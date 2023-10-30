/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nnt.repository;

import com.nnt.hibernate.HibernateUtils;
import com.nnt.pojo.Tintuc;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;

/**
 *
 * @author Admin
 */
public class TintucRepository {

    public List<Tintuc> getTintuc(Map<String, String> params) {
//        try (Session session = HibernateUtils.getFactory().openSession()) {
//            CriteriaBuilder b = session.getCriteriaBuilder();
//            CriteriaQuery<Tintuc> q = b.createQuery(Tintuc.class);
//            Root root = q.from(Tintuc.class);
//            q.select(root);
//
//            if (params != null) {
//                List<Predicate> predicates = new ArrayList<>();
//                
//                String tukhoa = params.get("tukhoa");
//                if (tukhoa != null && tukhoa.isEmpty()) 
//                    predicates.add(b.like(root.get("ten"), String.format("%%%s%%", tukhoa)));   
//                
//                String danhmucId = params.get("danhmucId");
//                if (danhmucId != null && !danhmucId.isEmpty())
//                    predicates.add(b.lessThanOrEqualTo(root.get("danhmuctintucId"), Integer.parseInt(danhmucId)));
//                
//                q.where(predicates.toArray(Predicate[]::new ));
//            }
//
//            q.orderBy(b.desc(root.get("id")));
//
//            Query query = session.createQuery(q);
//            return query.getResultList();
//        }

        try (Session session = HibernateUtils.getFactory().openSession()) {
            CriteriaBuilder b = session.getCriteriaBuilder();
            CriteriaQuery<Tintuc> q = b.createQuery(Tintuc.class);
            Root root = q.from(Tintuc.class);
            q.select(root);

            if (params != null) {
                List<Predicate> predicates = new ArrayList<>();

                String kw = params.get("kw");
                if (kw != null && !kw.isEmpty()) {
                    predicates.add(b.like(root.get("ten"), String.format("%%%s%%", kw)));
                }

                

                String danhmucId = params.get("danhmucId");
                if (danhmucId != null && !danhmucId.isEmpty()) {
                    predicates.add(b.lessThanOrEqualTo(root.get("danhmuctintucId"), Integer.parseInt(danhmucId)));
                }

                q.where(predicates.toArray(Predicate[]::new));
            }

           q.orderBy(b.desc(root.get("id")));

            Query query = session.createQuery(q);
            return query.getResultList();
        }
    }
}
