package com.uav.pojo;

import com.uav.pojo.Buses;
import com.uav.pojo.Users;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-09-02T15:46:58")
@StaticMetamodel(Ticket.class)
public class Ticket_ { 

    public static volatile SingularAttribute<Ticket, Short> tstatusPay;
    public static volatile SingularAttribute<Ticket, Integer> amount;
    public static volatile SingularAttribute<Ticket, Integer> total;
    public static volatile SingularAttribute<Ticket, Buses> busesId;
    public static volatile SingularAttribute<Ticket, Integer> pickupStationId;
    public static volatile SingularAttribute<Ticket, Integer> arriveStationId;
    public static volatile SingularAttribute<Ticket, Date> createdatetime;
    public static volatile SingularAttribute<Ticket, Users> userId;
    public static volatile SingularAttribute<Ticket, Integer> tid;
    public static volatile SingularAttribute<Ticket, String> username;

}