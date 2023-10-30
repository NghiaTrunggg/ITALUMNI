/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nnt.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "nguoidung")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nguoidung.findAll", query = "SELECT n FROM Nguoidung n"),
    @NamedQuery(name = "Nguoidung.findById", query = "SELECT n FROM Nguoidung n WHERE n.id = :id"),
    @NamedQuery(name = "Nguoidung.findByHo", query = "SELECT n FROM Nguoidung n WHERE n.ho = :ho"),
    @NamedQuery(name = "Nguoidung.findByTen", query = "SELECT n FROM Nguoidung n WHERE n.ten = :ten"),
    @NamedQuery(name = "Nguoidung.findByTendn", query = "SELECT n FROM Nguoidung n WHERE n.tendn = :tendn"),
    @NamedQuery(name = "Nguoidung.findByMatkhau", query = "SELECT n FROM Nguoidung n WHERE n.matkhau = :matkhau"),
    @NamedQuery(name = "Nguoidung.findByNienkhoa", query = "SELECT n FROM Nguoidung n WHERE n.nienkhoa = :nienkhoa"),
    @NamedQuery(name = "Nguoidung.findByPhanquyen", query = "SELECT n FROM Nguoidung n WHERE n.phanquyen = :phanquyen"),
    @NamedQuery(name = "Nguoidung.findByNgaysinh", query = "SELECT n FROM Nguoidung n WHERE n.ngaysinh = :ngaysinh"),
    @NamedQuery(name = "Nguoidung.findByHinhdaidien", query = "SELECT n FROM Nguoidung n WHERE n.hinhdaidien = :hinhdaidien")})
public class Nguoidung implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ho")
    private String ho;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ten")
    private String ten;
    @Basic(optional = false)
    @NotNull(message =  "{nguoidung.tendn.notNull}")
    @Size(min = 1, max = 50)
    @Column(name = "tendn")
    private String tendn;
    @Basic(optional = false)
    @NotNull(message =  "{nguoidung.matkhau.notNull}")
    @Size(min = 1, max = 300)
    @Column(name = "matkhau")
    private String matkhau;
    @Basic(optional = false)
    @Size(min = 1, max = 45)
    @Column(name = "nienkhoa")
    private String nienkhoa;
    @Basic(optional = false)  
    @Size(min = 1, max = 45)
    @Column(name = "phanquyen")
    private String phanquyen;
    @Column(name = "ngaysinh")
    @Temporal(TemporalType.DATE)
    private Date ngaysinh;
    @Size(max = 2147483647)
    @Column(name = "hinhdaidien")
    private String hinhdaidien;
    @OneToMany(mappedBy = "nguoidungId")
    @JsonIgnore
    private Set<Binhluan> binhluanSet;
    


    public Nguoidung() {
    }

    public Nguoidung(Integer id) {
        this.id = id;
    }

    public Nguoidung(Integer id, String ho, String ten, String tendn, String matkhau, String nienkhoa, String phanquyen) {
        this.id = id;
        this.ho = ho;
        this.ten = ten;
        this.tendn = tendn;
        this.matkhau = matkhau;
        this.nienkhoa = nienkhoa;
        this.phanquyen = phanquyen;
    }
    
    @Transient
    private MultipartFile file;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getTendn() {
        return tendn;
    }

    public void setTendn(String tendn) {
        this.tendn = tendn;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public String getNienkhoa() {
        return nienkhoa;
    }

    public void setNienkhoa(String nienkhoa) {
        this.nienkhoa = nienkhoa;
    }

    public String getPhanquyen() {
        return phanquyen;
    }

    public void setPhanquyen(String phanquyen) {
        this.phanquyen = phanquyen;
    }

    public Date getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(Date ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getHinhdaidien() {
        return hinhdaidien;
    }

    public void setHinhdaidien(String hinhdaidien) {
        this.hinhdaidien = hinhdaidien;
    }

    @XmlTransient
    public Set<Binhluan> getBinhluanSet() {
        return binhluanSet;
    }

    public void setBinhluanSet(Set<Binhluan> binhluanSet) {
        this.binhluanSet = binhluanSet;
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
        if (!(object instanceof Nguoidung)) {
            return false;
        }
        Nguoidung other = (Nguoidung) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nnt.pojo.Nguoidung[ id=" + id + " ]";
    }
    
    public MultipartFile getFile() {
        return file;
    }
    
    public void setFile(MultipartFile file) {
        this.file = file;
    }
    
}
