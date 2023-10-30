package com.nnt.pojo;

import com.nnt.pojo.TintucTag;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-10-19T22:21:37", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Tag.class)
public class Tag_ { 

    public static volatile SingularAttribute<Tag, Integer> id;
    public static volatile SingularAttribute<Tag, String> ten;
    public static volatile SetAttribute<Tag, TintucTag> tintucTagSet;

}