package com.gentech.erp.hr.mapper;
import com.gentech.erp.hr.dto.DependantsDto;
import com.gentech.erp.hr.entity.Dependants;

public class DependantsMapper {
    public static Dependants DtoToObject(DependantsDto dto)
    {
        Dependants obj = new Dependants(

                dto.getDependantName(),
                dto.getDependantAge(),
                dto.getMedicalCard());

        return obj;
    }
    public static DependantsDto ObjectToDto(Dependants obj)
    {
        DependantsDto dto = new DependantsDto(
                obj.getDependantId(),
                obj.getDependantName(),
                obj.getDependantAge(),
                obj.getMedicalCard());
        return dto;
    }
}


