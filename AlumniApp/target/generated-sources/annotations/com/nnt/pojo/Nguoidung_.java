package com.nnt.pojo;

import com.nnt.pojo.Binhluan;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2023-10-31T00:11:53")
@StaticMetamodel(Nguoidung.class)
public class Nguoidung_ { 

    public static volatile SingularAttribute<Nguoidung, String> phanquyen;
    public static volatile SingularAttribute<Nguoidung, String> matkhau;
    public static volatile SetAttribute<Nguoidung, Binhluan> binhluanSet;
    public static volatile SingularAttribute<Nguoidung, String> tendn;
    public static volatile SingularAttribute<Nguoidung, String> ho;
    public static volatile SingularAttribute<Nguoidung, Date> ngaysinh;
    public static volatile SingularAttribute<Nguoidung, String> nienkhoa;
    public static volatile SingularAttribute<Nguoidung, String> hinhdaidien;
    public static volatile SingularAttribute<Nguoidung, Integer> id;
    public static volatile SingularAttribute<Nguoidung, String> ten;

}