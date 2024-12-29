package com.gentech.erp.hr.mapper;

import com.gentech.erp.hr.dto.MedicalEntriesDto;
import com.gentech.erp.hr.entity.MedicalEntries;

public class MedicalEntriesMapper {

    public static MedicalEntries dtoToObject(MedicalEntriesDto dto) {
        MedicalEntries obj = new MedicalEntries();
        obj.setMedicalEntryId(dto.getMedicalEntryId());
        obj.setDependant(dto.getDependant());
        obj.setMedicalFiles(dto.getMedicalFiles());
        obj.setRequestAmount(dto.getRequestAmount());
        return obj;
    }

    public static MedicalEntriesDto objectToDto(MedicalEntries obj) {
        MedicalEntriesDto dto = new MedicalEntriesDto();
        dto.setMedicalEntryId(obj.getMedicalEntryId());
        dto.setDependant(obj.getDependant());
        dto.setMedicalFiles(obj.getMedicalFiles());
        dto.setRequestAmount(obj.getRequestAmount());
        return dto;
    }
}