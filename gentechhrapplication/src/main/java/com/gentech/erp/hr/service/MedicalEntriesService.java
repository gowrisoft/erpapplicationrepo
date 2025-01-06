package com.gentech.erp.hr.service;

import com.gentech.erp.hr.dto.MedicalEntriesDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface MedicalEntriesService {
    MedicalEntriesDto saveMedicalEntry(Long dependantId, MultipartFile medicalFiles, Double requestAmount) throws IOException;

    List<MedicalEntriesDto> getAllMedicalEntries();

    MedicalEntriesDto getMedicalEntryById(Long MedicalEntryId);

    void deleteItemById(Long id);

    List<MedicalEntriesDto> getMedicalEntryByeEmployeeId(Long employeeId);

    MedicalEntriesDto updateMedicalEntry(Long dependantId, MultipartFile medicalFiles, Double requestAmount, Long medicalEntryId) throws IOException;
}