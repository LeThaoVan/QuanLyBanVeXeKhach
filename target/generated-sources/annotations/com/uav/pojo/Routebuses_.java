package com.uav.pojo;

import com.uav.pojo.Buses;
import com.uav.pojo.Comment;
import com.uav.pojo.Route;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-09-02T15:46:58")
@StaticMetamodel(Routebuses.class)
public class Routebuses_ { 

    public static volatile SingularAttribute<Routebuses, Integer> soghe;
    public static volatile SingularAttribute<Routebuses, Route> routeId;
    public static volatile SingularAttribute<Routebuses, Buses> busesId;
    public static volatile SingularAttribute<Routebuses, Integer> price;
    public static volatile CollectionAttribute<Routebuses, Comment> commentCollection;
    public static volatile SingularAttribute<Routebuses, String> ngaydi;
    public static volatile SingularAttribute<Routebuses, Integer> rbid;
    public static volatile SingularAttribute<Routebuses, String> giodi;

}