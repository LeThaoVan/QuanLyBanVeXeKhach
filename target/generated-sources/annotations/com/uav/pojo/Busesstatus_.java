package com.uav.pojo;

import com.uav.pojo.Buses;
import com.uav.pojo.Users;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-09-02T15:46:58")
@StaticMetamodel(Busesstatus.class)
public class Busesstatus_ { 

    public static volatile SingularAttribute<Busesstatus, Integer> bsid;
    public static volatile SingularAttribute<Busesstatus, Date> leavingtime;
    public static volatile SingularAttribute<Busesstatus, Buses> busesId;
    public static volatile SingularAttribute<Busesstatus, Users> staffconfirm;

}