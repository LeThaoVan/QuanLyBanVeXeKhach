package com.uav.pojo;

import com.uav.pojo.Buses;
import com.uav.pojo.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-10-07T09:23:06")
@StaticMetamodel(Garage.class)
public class Garage_ { 

    public static volatile SingularAttribute<Garage, User> idUser;
    public static volatile SingularAttribute<Garage, Date> createTime;
    public static volatile SingularAttribute<Garage, String> name;
    public static volatile SingularAttribute<Garage, Integer> id;
    public static volatile CollectionAttribute<Garage, Buses> busesCollection;
    public static volatile SingularAttribute<Garage, Short> status;

}