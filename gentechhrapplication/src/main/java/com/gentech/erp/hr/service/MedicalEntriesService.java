package com.gentech.erp.hr.service;

import com.gentech.erp.hr.dto.MedicalEntriesDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface MedicalEntriesService {

    void saveMedicalEntry(Long dependantId,
                          MultipartFile medicalFiles, Double requestAmount) throws IOException;

    List<MedicalEntriesDto> getAllMedicalEntries();

    MedicalEntriesDto getMedicalEntryByMedicalEntryId(Long medicalEntryId) throws Exception;

    MedicalEntriesDto updateItem(MedicalEntriesDto medicalEntriesDto, Long medicalEntryId) throws Exception;

    void deleteItemById(Long id);
}