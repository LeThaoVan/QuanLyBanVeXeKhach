package com.uav.pojo;

import com.uav.pojo.Busesstatus;
import com.uav.pojo.Comment;
import com.uav.pojo.Ticket;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-09-02T15:46:58")
@StaticMetamodel(Users.class)
public class Users_ { 

    public static volatile SingularAttribute<Users, String> firstname;
    public static volatile SingularAttribute<Users, String> sdt;
    public static volatile SingularAttribute<Users, String> pass;
    public static volatile CollectionAttribute<Users, Busesstatus> busesstatusCollection;
    public static volatile CollectionAttribute<Users, Comment> commentCollection;
    public static volatile SingularAttribute<Users, String> rode;
    public static volatile SingularAttribute<Users, String> avatar;
    public static volatile SingularAttribute<Users, Integer> userid;
    public static volatile SingularAttribute<Users, String> lastname;
    public static volatile SingularAttribute<Users, Date> createdAt;
    public static volatile CollectionAttribute<Users, Ticket> ticketCollection;
    public static volatile SingularAttribute<Users, Date> yearofbirth;
    public static volatile SingularAttribute<Users, String> email;
    public static volatile SingularAttribute<Users, String> username;

}