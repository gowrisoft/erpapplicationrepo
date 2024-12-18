package com.gentech.erp.hr.mapper;

import com.gentech.erp.hr.dto.EmployeeMedicalCardDto;
import com.gentech.erp.hr.entity.EmployeeMedicalCard;

public class EmployeeMedicalCardMapper {

    public static EmployeeMedicalCardDto ObjectToDto(EmployeeMedicalCard obj)
    {
        EmployeeMedicalCardDto dto = new EmployeeMedicalCardDto(
                obj.geteCard(),
                obj.getEmployee(),
                obj.getDependants()
        );
        return dto;
    }

    public static EmployeeMedicalCard DtoToObject(EmployeeMedicalCardDto dto)
    {
        EmployeeMedicalCard obj = new EmployeeMedicalCard(
                dto.geteCard(),
                dto.getEmployee(),
                dto.getDependants()
        );
        return obj;
    }

}