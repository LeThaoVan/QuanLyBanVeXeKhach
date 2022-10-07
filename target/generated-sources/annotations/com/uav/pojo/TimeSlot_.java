package com.uav.pojo;

import com.uav.pojo.DepartureTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-10-07T09:23:06")
@StaticMetamodel(TimeSlot.class)
public class TimeSlot_ { 

    public static volatile SingularAttribute<TimeSlot, String> hour;
    public static volatile CollectionAttribute<TimeSlot, DepartureTime> departureTimeCollection;
    public static volatile SingularAttribute<TimeSlot, Integer> id;

}