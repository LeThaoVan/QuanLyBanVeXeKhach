package com.uav.pojo;

import com.uav.pojo.RouteBus;
import com.uav.pojo.RouteStation;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-10-07T09:23:06")
@StaticMetamodel(Route.class)
public class Route_ { 

    public static volatile SingularAttribute<Route, String> image;
    public static volatile CollectionAttribute<Route, RouteBus> routeBusCollection;
    public static volatile SingularAttribute<Route, Integer> startProvince;
    public static volatile SingularAttribute<Route, String> name;
    public static volatile SingularAttribute<Route, Integer> destination;
    public static volatile SingularAttribute<Route, Integer> id;
    public static volatile SingularAttribute<Route, Date> createAt;
    public static volatile CollectionAttribute<Route, RouteStation> routeStationCollection;

}