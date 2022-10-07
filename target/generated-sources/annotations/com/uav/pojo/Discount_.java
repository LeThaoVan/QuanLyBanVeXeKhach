package com.uav.pojo;

import com.uav.pojo.DiscountTicket;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-10-07T09:23:06")
@StaticMetamodel(Discount.class)
public class Discount_ { 

    public static volatile SingularAttribute<Discount, Double> amount;
    public static volatile SingularAttribute<Discount, String> context;
    public static volatile SingularAttribute<Discount, Short> active;
    public static volatile CollectionAttribute<Discount, DiscountTicket> discountTicketCollection;
    public static volatile SingularAttribute<Discount, Integer> id;

}