package com.uav.pojo;

import com.uav.pojo.Buses;
import com.uav.pojo.Comment;
import com.uav.pojo.Garage;
import com.uav.pojo.Ticket;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-10-07T09:23:06")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, String> lastName;
    public static volatile SingularAttribute<User, Date> birthDay;
    public static volatile SingularAttribute<User, String> role;
    public static volatile SingularAttribute<User, String> pass;
    public static volatile CollectionAttribute<User, Comment> commentCollection;
    public static volatile SingularAttribute<User, String> avatar;
    public static volatile SingularAttribute<User, String> userName;
    public static volatile SingularAttribute<User, Date> createAt;
    public static volatile SingularAttribute<User, String> firstName;
    public static volatile CollectionAttribute<User, Ticket> ticketCollection;
    public static volatile SingularAttribute<User, String> phone;
    public static volatile SingularAttribute<User, Integer> id;
    public static volatile CollectionAttribute<User, Garage> garageCollection;
    public static volatile CollectionAttribute<User, Buses> busesCollection;
    public static volatile SingularAttribute<User, String> email;

}