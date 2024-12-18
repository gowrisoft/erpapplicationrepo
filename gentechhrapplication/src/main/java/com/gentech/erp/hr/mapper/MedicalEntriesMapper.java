package com.gentech.erp.hr.mapper;

import com.gentech.erp.hr.dto.MedicalEntriesDto;
import com.gentech.erp.hr.entity.MedicalEntries;

public class MedicalEntriesMapper {
    public static MedicalEntries DtoToObject(MedicalEntriesDto dto)
    {
        MedicalEntries obj = new MedicalEntries(
                dto.getMRno(),
                dto.getEmployee(),
                dto.getMedicalCard(),
                dto.getDependantName(),
                dto.getDependantAge(),
                dto.getMedicalFiles(),
                dto.getRequestAmount()
        );
        return obj;
    }

    public static MedicalEntriesDto DtoToObject(MedicalEntries dto)
    {
        MedicalEntriesDto obj = new MedicalEntriesDto(
                dto.getMRno(),
                dto.getEmployee(),
                dto.getMedicalCard(),
                dto.getDependantName(),
                dto.getDependantAge(),
                dto.getMedicalFiles(),
                dto.getRequestAmount()
        );
        return obj;
    }

}
