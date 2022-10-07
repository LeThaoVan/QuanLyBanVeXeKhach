package com.uav.pojo;

import com.uav.pojo.Buses;
import com.uav.pojo.Comment;
import com.uav.pojo.Route;
import com.uav.pojo.RouteBusDepartureTime;
import com.uav.pojo.RouteBusStation;
import com.uav.pojo.Star;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-10-07T09:23:06")
@StaticMetamodel(RouteBus.class)
public class RouteBus_ { 

    public static volatile CollectionAttribute<RouteBus, RouteBusStation> routeBusStationCollection;
    public static volatile SingularAttribute<RouteBus, Buses> busId;
    public static volatile SingularAttribute<RouteBus, Route> routeId;
    public static volatile CollectionAttribute<RouteBus, Comment> commentCollection;
    public static volatile SingularAttribute<RouteBus, Integer> id;
    public static volatile CollectionAttribute<RouteBus, RouteBusDepartureTime> routeBusDepartureTimeCollection;
    public static volatile CollectionAttribute<RouteBus, Star> starCollection;

}