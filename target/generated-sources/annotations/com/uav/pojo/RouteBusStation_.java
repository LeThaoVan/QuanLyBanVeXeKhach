package com.uav.pojo;

import com.uav.pojo.RouteBus;
import com.uav.pojo.RouteStation;
import com.uav.pojo.Ticket;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-10-07T09:23:06")
@StaticMetamodel(RouteBusStation.class)
public class RouteBusStation_ { 

    public static volatile CollectionAttribute<RouteBusStation, Ticket> ticketCollection;
    public static volatile SingularAttribute<RouteBusStation, Integer> price;
    public static volatile SingularAttribute<RouteBusStation, RouteStation> routeStationId;
    public static volatile SingularAttribute<RouteBusStation, Integer> id;
    public static volatile SingularAttribute<RouteBusStation, RouteBus> routeBusId;

}