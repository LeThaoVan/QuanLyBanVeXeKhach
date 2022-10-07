package com.uav.pojo;

import com.uav.pojo.Route;
import com.uav.pojo.RouteBusStation;
import com.uav.pojo.Station;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-10-07T09:23:06")
@StaticMetamodel(RouteStation.class)
public class RouteStation_ { 

    public static volatile CollectionAttribute<RouteStation, RouteBusStation> routeBusStationCollection;
    public static volatile SingularAttribute<RouteStation, Route> routeId;
    public static volatile SingularAttribute<RouteStation, Integer> id;
    public static volatile SingularAttribute<RouteStation, Short> typeOfStation;
    public static volatile SingularAttribute<RouteStation, Station> stationId;

}