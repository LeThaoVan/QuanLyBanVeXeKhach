package com.uav.pojo;

import com.uav.pojo.RouteBusDepartureTime;
import com.uav.pojo.TimeSlot;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-10-07T09:23:06")
@StaticMetamodel(DepartureTime.class)
public class DepartureTime_ { 

    public static volatile SingularAttribute<DepartureTime, TimeSlot> timeSlotId;
    public static volatile SingularAttribute<DepartureTime, Integer> id;
    public static volatile SingularAttribute<DepartureTime, Date> departureDate;
    public static volatile CollectionAttribute<DepartureTime, RouteBusDepartureTime> routeBusDepartureTimeCollection;

}