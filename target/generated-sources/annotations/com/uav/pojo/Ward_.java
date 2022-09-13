package com.uav.pojo;

import com.uav.pojo.District;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-09-02T15:46:58")
@StaticMetamodel(Ward.class)
public class Ward_ { 

    public static volatile SingularAttribute<Ward, District> districtId;
    public static volatile SingularAttribute<Ward, String> prefix;
    public static volatile SingularAttribute<Ward, String> name;
    public static volatile SingularAttribute<Ward, Integer> id;
    public static volatile SingularAttribute<Ward, Integer> provinceId;

}