package com.uav.pojo;

import com.uav.pojo.RouteStation;
import com.uav.pojo.Ticket;
import com.uav.pojo.Ward;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-10-07T09:23:06")
@StaticMetamodel(Station.class)
public class Station_ { 

    public static volatile CollectionAttribute<Station, Ticket> ticketCollection;
    public static volatile SingularAttribute<Station, String> name;
    public static volatile SingularAttribute<Station, Integer> id;
    public static volatile SingularAttribute<Station, Ward> wardId;
    public static volatile CollectionAttribute<Station, RouteStation> routeStationCollection;

}