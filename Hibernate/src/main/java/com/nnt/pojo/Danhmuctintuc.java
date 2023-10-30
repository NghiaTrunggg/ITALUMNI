/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nnt.pojo;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "danhmuctintuc")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Danhmuctintuc.findAll", query = "SELECT d FROM Danhmuctintuc d"),
    @NamedQuery(name = "Danhmuctintuc.findById", query = "SELECT d FROM Danhmuctintuc d WHERE d.id = :id"),
    @NamedQuery(name = "Danhmuctintuc.findByTen", query = "SELECT d FROM Danhmuctintuc d WHERE d.ten = :ten")})
public class Danhmuctintuc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "ten")
    private String ten;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "danhmuctintucId")
    private Set<Tintuc> tintucSet;

    public Danhmuctintuc() {
    }

    public Danhmuctintuc(Integer id) {
        this.id = id;
    }

    public Danhmuctintuc(Integer id, String ten) {
        this.id = id;
        this.ten = ten;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    @XmlTransient
    public Set<Tintuc> getTintucSet() {
        return tintucSet;
    }

    public void setTintucSet(Set<Tintuc> tintucSet) {
        this.tintucSet = tintucSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Danhmuctintuc)) {
            return false;
        }
        Danhmuctintuc other = (Danhmuctintuc) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nnt.pojo.Danhmuctintuc[ id=" + id + " ]";
    }
    
}
