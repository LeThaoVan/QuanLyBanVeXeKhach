package com.uav.pojo;

import com.uav.pojo.DiscountTicket;
import com.uav.pojo.RouteBusDepartureTime;
import com.uav.pojo.RouteBusStation;
import com.uav.pojo.Station;
import com.uav.pojo.TicketChair;
import com.uav.pojo.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-10-07T09:23:06")
@StaticMetamodel(Ticket.class)
public class Ticket_ { 

    public static volatile SingularAttribute<Ticket, Integer> amount;
    public static volatile SingularAttribute<Ticket, Integer> total;
    public static volatile CollectionAttribute<Ticket, TicketChair> ticketChairCollection;
    public static volatile SingularAttribute<Ticket, RouteBusStation> routeBusStationId;
    public static volatile SingularAttribute<Ticket, Station> pickupStationId;
    public static volatile CollectionAttribute<Ticket, DiscountTicket> discountTicketCollection;
    public static volatile SingularAttribute<Ticket, Integer> id;
    public static volatile SingularAttribute<Ticket, Short> payStatus;
    public static volatile SingularAttribute<Ticket, User> userId;
    public static volatile SingularAttribute<Ticket, Date> createAt;
    public static volatile SingularAttribute<Ticket, RouteBusDepartureTime> routeBusDepartureTimeId;

}