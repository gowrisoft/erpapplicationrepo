package com.gentech.erp.hr.service;

import com.gentech.erp.hr.dto.MedicalEntriesDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface MedicalEntriesService {

    void saveMedicalEntry(Long empId, Long dependantId,
                          String medicalFiles, Double requestAmount) throws IOException;

    List<MedicalEntriesDto> getAllMedicalEntries();

    MedicalEntriesDto getMedicalEntryByMRno(Long MRno) throws Exception;

    MedicalEntriesDto updateItem(MedicalEntriesDto upd, Long id) throws Exception;

    void deleteItemById(Long id);
}
