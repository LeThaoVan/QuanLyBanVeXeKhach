package com.uav.pojo;

import com.uav.pojo.District;
import com.uav.pojo.Ward;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-10-07T09:23:06")
@StaticMetamodel(Province.class)
public class Province_ { 

    public static volatile SingularAttribute<Province, String> code;
    public static volatile CollectionAttribute<Province, District> districtCollection;
    public static volatile SingularAttribute<Province, String> name;
    public static volatile SingularAttribute<Province, Integer> id;
    public static volatile CollectionAttribute<Province, Ward> wardCollection;

}