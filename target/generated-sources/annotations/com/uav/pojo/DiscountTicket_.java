package com.uav.pojo;

import com.uav.pojo.Discount;
import com.uav.pojo.Ticket;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-10-07T09:23:06")
@StaticMetamodel(DiscountTicket.class)
public class DiscountTicket_ { 

    public static volatile SingularAttribute<DiscountTicket, Integer> id;
    public static volatile SingularAttribute<DiscountTicket, Discount> discountId;
    public static volatile SingularAttribute<DiscountTicket, Ticket> ticketId;

}