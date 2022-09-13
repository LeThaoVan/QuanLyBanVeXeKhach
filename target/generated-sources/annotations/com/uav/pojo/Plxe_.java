package com.uav.pojo;

import com.uav.pojo.Buses;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-09-02T15:46:58")
@StaticMetamodel(Plxe.class)
public class Plxe_ { 

    public static volatile SingularAttribute<Plxe, Integer> soGhe;
    public static volatile SingularAttribute<Plxe, Integer> lid;
    public static volatile SingularAttribute<Plxe, String> loaiXe;
    public static volatile SingularAttribute<Plxe, String> hangXe;
    public static volatile CollectionAttribute<Plxe, Buses> busesCollection;

}