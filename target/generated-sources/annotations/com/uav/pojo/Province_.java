package com.uav.pojo;

import com.uav.pojo.District;
import com.uav.pojo.Route;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-09-02T15:46:58")
@StaticMetamodel(Province.class)
public class Province_ { 

    public static volatile SingularAttribute<Province, String> code;
    public static volatile CollectionAttribute<Province, District> districtCollection;
    public static volatile CollectionAttribute<Province, Route> routeCollection;
    public static volatile SingularAttribute<Province, String> name;
    public static volatile SingularAttribute<Province, Integer> id;
    public static volatile CollectionAttribute<Province, Route> routeCollection1;

}