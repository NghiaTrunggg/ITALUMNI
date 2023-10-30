/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nnt.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "tintuc")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tintuc.findAll", query = "SELECT t FROM Tintuc t"),
    @NamedQuery(name = "Tintuc.findById", query = "SELECT t FROM Tintuc t WHERE t.id = :id"),
    @NamedQuery(name = "Tintuc.findByHinhanh", query = "SELECT t FROM Tintuc t WHERE t.hinhanh = :hinhanh"),
    @NamedQuery(name = "Tintuc.findByNgaydang", query = "SELECT t FROM Tintuc t WHERE t.ngaydang = :ngaydang")})
public class Tintuc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    
    @NotNull(message = "{tintuc.ten.notNull}")
    @Size(min = 5, max = 65535, message = "{tintuc.ten.lenErr}")
    @Column(name = "ten")
    private String ten;
    
    @NotNull(message = "{tintuc.tomtat.notNull}")
    @Size(min = 5, max = 65535, message = "{tintuc.tomtat.lenErr}")
    @Column(name = "tomtat")
    private String tomtat;
    
    @NotNull(message = "{tintuc.noidung.notNull}")
    @Size(max = 2147483647, message = "{tintuc.noidung.lenErr}")
    @Column(name = "noidung")
    private String noidung;
    @Size(max = 2147483647)
    @Column(name = "hinhanh")
    private String hinhanh;
    @Column(name = "ngaydang")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngaydang;
    @JoinColumn(name = "danhmuctintuc_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Danhmuctintuc danhmuctintucId;

    @Transient
    private MultipartFile file;

    public Tintuc() {
    }

    public Tintuc(Integer id) {
        this.id = id;
    }

    public Tintuc(Integer id, String ten) {
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

    public String getTomtat() {
        return tomtat;
    }

    public void setTomtat(String tomtat) {
        this.tomtat = tomtat;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }

    public Date getNgaydang() {
        return ngaydang;
    }

    public void setNgaydang(Date ngaydang) {
        this.ngaydang = ngaydang;
    }

    public Danhmuctintuc getDanhmuctintucId() {
        return danhmuctintucId;
    }

    public void setDanhmuctintucId(Danhmuctintuc danhmuctintucId) {
        this.danhmuctintucId = danhmuctintucId;
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
        if (!(object instanceof Tintuc)) {
            return false;
        }
        Tintuc other = (Tintuc) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nnt.pojo.Tintuc[ id=" + id + " ]";
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
