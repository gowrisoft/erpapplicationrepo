package com.gentech.erp.hr.mapper;

import com.gentech.erp.hr.dto.MedicalEntriesDto;
import com.gentech.erp.hr.entity.MedicalEntries;

public class MedicalEntriesMapper {
    public static MedicalEntries DtoToObject(MedicalEntriesDto dto) {
        MedicalEntries obj = new MedicalEntries(
                dto.getMRno(),
                dto.getDependant(),
                dto.getMedicalFiles(),
                dto.getRequestAmount(),
                dto.getEmployee()
        );
        return obj;
    }

    public static MedicalEntriesDto ObjectToDto(MedicalEntries obj) {
        MedicalEntriesDto dto = new MedicalEntriesDto();
        dto.setMRno(obj.getMRno());
        dto.setDependant(obj.getDependants());
        dto.setMedicalFiles(obj.getMedicalFiles());
        dto.setRequestAmount(obj.getRequestAmount());
        dto.setEmployee(obj.getEmployee());
        return dto;
    }
}
