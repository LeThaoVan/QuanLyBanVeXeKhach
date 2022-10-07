package com.uav.pojo;

import com.uav.pojo.Garage;
import com.uav.pojo.RouteBus;
import com.uav.pojo.TypeOfBus;
import com.uav.pojo.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-10-07T09:23:06")
@StaticMetamodel(Buses.class)
public class Buses_ { 

    public static volatile SingularAttribute<Buses, String> image;
    public static volatile CollectionAttribute<Buses, RouteBus> routeBusCollection;
    public static volatile SingularAttribute<Buses, User> driverId;
    public static volatile SingularAttribute<Buses, Garage> garageId;
    public static volatile SingularAttribute<Buses, String> name;
    public static volatile SingularAttribute<Buses, TypeOfBus> typeOfBusId;
    public static volatile SingularAttribute<Buses, Short> active;
    public static volatile SingularAttribute<Buses, Integer> id;
    public static volatile SingularAttribute<Buses, Date> createAt;

}