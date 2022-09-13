package com.uav.pojo;

import com.uav.pojo.Province;
import com.uav.pojo.Routebuses;
import com.uav.pojo.Routestation;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-09-02T15:46:58")
@StaticMetamodel(Route.class)
public class Route_ { 

    public static volatile SingularAttribute<Route, String> image;
    public static volatile SingularAttribute<Route, Province> startingpoint;
    public static volatile CollectionAttribute<Route, Routebuses> routebusesCollection;
    public static volatile SingularAttribute<Route, Province> destination;
    public static volatile CollectionAttribute<Route, Routestation> routestationCollection;
    public static volatile SingularAttribute<Route, Date> createdatetime;
    public static volatile SingularAttribute<Route, Integer> rid;
    public static volatile SingularAttribute<Route, String> routename;

}