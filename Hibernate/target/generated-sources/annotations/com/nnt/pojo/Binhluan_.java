package com.nnt.pojo;

import com.nnt.pojo.Nguoidung;
import com.nnt.pojo.Tintuc;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-10-19T22:21:37", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Binhluan.class)
public class Binhluan_ { 

    public static volatile SingularAttribute<Binhluan, Tintuc> tintucId;
    public static volatile SingularAttribute<Binhluan, Nguoidung> nguoidungId;
    public static volatile SingularAttribute<Binhluan, Integer> id;
    public static volatile SingularAttribute<Binhluan, String> noidung;

}