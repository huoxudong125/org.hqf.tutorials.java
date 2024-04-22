package org.hqf.tutorials.java;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ConvertMapper {

   public static ConvertMapper INSTANCE =Mappers.getMapper(ConvertMapper.class);

    // A to B converter method
     B convertAToB(A a);
}
