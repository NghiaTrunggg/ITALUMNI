/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nnt.repository;

import com.nnt.hibernate.HibernateUtils;
import com.nnt.pojo.Danhmuctintuc;
import com.nnt.pojo.Tintuc;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;

/**
 *
 * @author Admin
 */
public class ThongkeRepository {

    public List<Object[]> tkTintucTheoDanhmuc() {
        try (Session session = HibernateUtils.getFactory().openSession()) {
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
}
