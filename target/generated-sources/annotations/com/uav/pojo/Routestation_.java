package com.uav.pojo;

import com.uav.pojo.Route;
import com.uav.pojo.Tram;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-09-02T15:46:58")
@StaticMetamodel(Routestation.class)
public class Routestation_ { 

    public static volatile SingularAttribute<Routestation, Tram> idTram;
    public static volatile SingularAttribute<Routestation, Route> routeId;
    public static volatile SingularAttribute<Routestation, Integer> id;
    public static volatile SingularAttribute<Routestation, Short> state;

}