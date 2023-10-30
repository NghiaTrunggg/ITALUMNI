package com.nnt.pojo;

import com.nnt.pojo.Nguoidung;
import com.nnt.pojo.Tintuc;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2023-10-31T00:11:53")
@StaticMetamodel(Binhluan.class)
public class Binhluan_ { 

    public static volatile SingularAttribute<Binhluan, Tintuc> tintucId;
    public static volatile SingularAttribute<Binhluan, Date> ngay;
    public static volatile SingularAttribute<Binhluan, Nguoidung> nguoidungId;
    public static volatile SingularAttribute<Binhluan, Integer> id;
    public static volatile SingularAttribute<Binhluan, String> noidung;

}