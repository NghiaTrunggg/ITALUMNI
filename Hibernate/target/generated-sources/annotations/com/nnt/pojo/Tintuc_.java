package com.nnt.pojo;

import com.nnt.pojo.Binhluan;
import com.nnt.pojo.Danhmuctintuc;
import com.nnt.pojo.TintucTag;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-10-19T22:21:37", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Tintuc.class)
public class Tintuc_ { 

    public static volatile SingularAttribute<Tintuc, String> hinhanh;
    public static volatile SingularAttribute<Tintuc, String> tomtat;
    public static volatile SetAttribute<Tintuc, Binhluan> binhluanSet;
    public static volatile SingularAttribute<Tintuc, Integer> id;
    public static volatile SingularAttribute<Tintuc, Danhmuctintuc> danhmuctintucId;
    public static volatile SingularAttribute<Tintuc, String> ten;
    public static volatile SingularAttribute<Tintuc, String> noidung;
    public static volatile SetAttribute<Tintuc, TintucTag> tintucTagSet;

}