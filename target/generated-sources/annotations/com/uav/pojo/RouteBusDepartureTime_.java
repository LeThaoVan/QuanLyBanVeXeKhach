package com.uav.pojo;

import com.uav.pojo.DepartureTime;
import com.uav.pojo.RouteBus;
import com.uav.pojo.Ticket;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-10-07T09:23:06")
@StaticMetamodel(RouteBusDepartureTime.class)
public class RouteBusDepartureTime_ { 

    public static volatile CollectionAttribute<RouteBusDepartureTime, Ticket> ticketCollection;
    public static volatile SingularAttribute<RouteBusDepartureTime, DepartureTime> departureTimeId;
    public static volatile SingularAttribute<RouteBusDepartureTime, Integer> id;
    public static volatile SingularAttribute<RouteBusDepartureTime, RouteBus> routeBusId;

}