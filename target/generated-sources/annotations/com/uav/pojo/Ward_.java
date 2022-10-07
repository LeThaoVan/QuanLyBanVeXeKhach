package com.uav.pojo;

import com.uav.pojo.District;
import com.uav.pojo.Province;
import com.uav.pojo.Station;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-10-07T09:23:06")
@StaticMetamodel(Ward.class)
public class Ward_ { 

    public static volatile SingularAttribute<Ward, District> districtId;
    public static volatile SingularAttribute<Ward, String> prefix;
    public static volatile SingularAttribute<Ward, String> name;
    public static volatile CollectionAttribute<Ward, Station> stationCollection;
    public static volatile SingularAttribute<Ward, Integer> id;
    public static volatile SingularAttribute<Ward, Province> provinceId;

}