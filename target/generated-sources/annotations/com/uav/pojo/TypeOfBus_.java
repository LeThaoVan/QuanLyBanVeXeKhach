package com.uav.pojo;

import com.uav.pojo.Buses;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-10-07T09:23:06")
@StaticMetamodel(TypeOfBus.class)
public class TypeOfBus_ { 

    public static volatile SingularAttribute<TypeOfBus, String> carBrand;
    public static volatile SingularAttribute<TypeOfBus, String> chair;
    public static volatile SingularAttribute<TypeOfBus, String> context;
    public static volatile SingularAttribute<TypeOfBus, Integer> id;
    public static volatile CollectionAttribute<TypeOfBus, Buses> busesCollection;

}