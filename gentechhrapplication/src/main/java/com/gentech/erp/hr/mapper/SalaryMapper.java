package com.gentech.erp.hr.mapper;

import com.gentech.erp.hr.dto.SalaryDto;
import com.gentech.erp.hr.entity.Salary;

public class SalaryMapper {
    public static Salary DtoToObject(SalaryDto dto) {
        Salary obj = new Salary(
                dto.getSalId(),
                dto.getEmployee(),
                dto.getBasicSalary(),
                dto.getMedicalClaim()
        );
        return obj;
    }

    public static SalaryDto DtoToObject(Salary dto) {
        SalaryDto obj = new SalaryDto(
                dto.getEmployee(),
                dto.getSalId(),
                dto.getBasicSalary(),
                dto.getMedicalClaim()
        );
        return obj;
    }

}

