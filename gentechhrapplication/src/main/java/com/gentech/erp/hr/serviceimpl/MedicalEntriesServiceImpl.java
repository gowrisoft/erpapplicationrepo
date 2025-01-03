package com.gentech.erp.hr.serviceimpl;

import com.gentech.erp.hr.dto.MedicalEntriesDto;
import com.gentech.erp.hr.entity.Dependant;
import com.gentech.erp.hr.entity.MedicalEntries;
import com.gentech.erp.hr.mapper.MedicalEntriesMapper;
import com.gentech.erp.hr.repository.DependantsRepository;
import com.gentech.erp.hr.repository.MedicalEntriesRepository;
import com.gentech.erp.hr.service.MedicalEntriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MedicalEntriesServiceImpl implements MedicalEntriesService {

    @Autowired
    private MedicalEntriesRepository medicalEntriesRepository;

    @Autowired
    private DependantsRepository dependantsRepository;

    @Override
    public void saveMedicalEntry(Long dependantId, MultipartFile medicalFiles, Double requestAmount) throws IOException {
        Dependant dependant = dependantsRepository.findById(dependantId)
                .orElseThrow(() -> new RuntimeException("Dependant not found with ID: " + dependantId));

        MedicalEntries medicalEntry = new MedicalEntries();
        medicalEntry.setDependant(dependant);
        medicalEntry.setMedicalFiles(medicalFiles.getBytes());
        medicalEntry.setRequestAmount(requestAmount);

        medicalEntriesRepository.save(medicalEntry);
    }

    @Override
    public List<MedicalEntriesDto> getAllMedicalEntries() {
        List<MedicalEntries> obj = medicalEntriesRepository.findAll();
        List<MedicalEntriesDto> objDto = new ArrayList<>();
        for (int i = 0; i < obj.size(); i++) {
            objDto.add(MedicalEntriesMapper.objectToDto(obj.get(i)));
        }
        return objDto;
    }

    @Override
    public MedicalEntriesDto getMedicalEntryByMedicalEntryId(Long medicalEntryId) throws Exception {
        Optional<MedicalEntries> obj = medicalEntriesRepository.findById(medicalEntryId);
        if (obj.isPresent()) {
            MedicalEntriesDto dto = MedicalEntriesMapper.objectToDto(obj.get());
            return dto;

        }
        throw new Exception("The item is not present");
    }

    @Override
    public MedicalEntriesDto updateItem(MedicalEntriesDto upd, Long medicalEntryId) throws Exception {
        Optional<MedicalEntries> obj = medicalEntriesRepository.findById(medicalEntryId);
        if (obj.isPresent()) {
            MedicalEntries n = obj.get();
            n.setDependant(upd.getDependant());
            n.setMedicalFiles(upd.getMedicalFiles());
            n.setMedicalEntryId(upd.getMedicalEntryId());
            n.setRequestAmount(upd.getRequestAmount());

            medicalEntriesRepository.save(n);
            upd = MedicalEntriesMapper.objectToDto(n);
            return upd;
        }
        throw new Exception("The item is not present");
    }

    @Override
    public void deleteItemById(Long medicalEntryId) {
        medicalEntriesRepository.deleteById(medicalEntryId);

    }
}