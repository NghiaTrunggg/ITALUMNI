package com.nnt.pojo;

import com.nnt.pojo.Binhluan;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-10-19T22:21:37", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Nguoidung.class)
public class Nguoidung_ { 

    public static volatile SingularAttribute<Nguoidung, String> phanquyen;
    public static volatile SingularAttribute<Nguoidung, String> matkhau;
    public static volatile SetAttribute<Nguoidung, Binhluan> binhluanSet;
    public static volatile SingularAttribute<Nguoidung, String> tendn;
    public static volatile SingularAttribute<Nguoidung, String> ho;
    public static volatile SingularAttribute<Nguoidung, Date> ngaysinh;
    public static volatile SingularAttribute<Nguoidung, String> nienkhoa;
    public static volatile SingularAttribute<Nguoidung, Integer> id;
    public static volatile SingularAttribute<Nguoidung, String> ten;

}