package com.uav.pojo;

import com.uav.pojo.Busesstatus;
import com.uav.pojo.Plxe;
import com.uav.pojo.Routebuses;
import com.uav.pojo.Ticket;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-09-02T15:46:58")
@StaticMetamodel(Buses.class)
public class Buses_ { 

    public static volatile SingularAttribute<Buses, String> image;
    public static volatile SingularAttribute<Buses, String> busesName;
    public static volatile SingularAttribute<Buses, Integer> driverID;
    public static volatile SingularAttribute<Buses, Boolean> bstatus;
    public static volatile CollectionAttribute<Buses, Ticket> ticketCollection;
    public static volatile CollectionAttribute<Buses, Busesstatus> busesstatusCollection;
    public static volatile CollectionAttribute<Buses, Routebuses> routebusesCollection;
    public static volatile SingularAttribute<Buses, Date> createdatetime;
    public static volatile SingularAttribute<Buses, Plxe> loaixeID;
    public static volatile SingularAttribute<Buses, Integer> bid;

}