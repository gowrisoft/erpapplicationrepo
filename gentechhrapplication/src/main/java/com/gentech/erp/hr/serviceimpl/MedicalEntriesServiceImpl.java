package com.gentech.erp.hr.serviceimpl;

import com.gentech.erp.hr.dto.MedicalEntriesDto;
import com.gentech.erp.hr.entity.Dependant;
import com.gentech.erp.hr.entity.MedicalEntries;
import com.gentech.erp.hr.repository.DependantsRepository;
import com.gentech.erp.hr.repository.EmployeeRepository;
import com.gentech.erp.hr.repository.MedicalEntriesRepository;
import com.gentech.erp.hr.service.MedicalEntriesService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@Service
public class MedicalEntriesServiceImpl implements MedicalEntriesService {

    @Autowired
    private MedicalEntriesRepository medicalEntriesRepository;
    @Autowired
    private DependantsRepository dependantsRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public MedicalEntriesDto saveMedicalEntry(Long dependantId, MultipartFile medicalFiles, Double requestAmount) throws IOException {
        Dependant dependant = dependantsRepository.findById(dependantId)
                .orElseThrow(() -> new RuntimeException("Dependant not found with ID: " + dependantId));

        MedicalEntries medicalEntry = new MedicalEntries();
        medicalEntry.setDependant(dependant);
        medicalEntry.setMedicalFiles(medicalFiles.getBytes());
        medicalEntry.setRequestAmount(requestAmount);
        return modelMapper.map(medicalEntriesRepository.save(medicalEntry), MedicalEntriesDto.class);
    }

    @Override
    public List<MedicalEntriesDto> getAllMedicalEntries() {
        return medicalEntriesRepository.findAll().stream()
                .map(medicalEntry -> modelMapper.map(medicalEntry, MedicalEntriesDto.class))
                .toList();
    }

    @Override
    public MedicalEntriesDto getMedicalEntryById(Long MedicalEntryId) {
        MedicalEntries medicalEntry = medicalEntriesRepository.findById(MedicalEntryId)
                .orElseThrow(() -> new RuntimeException("Medical Entry not found with ID: " + MedicalEntryId));
        return modelMapper.map(medicalEntry, MedicalEntriesDto.class);
    }

    @Override
    public void deleteItemById(Long id) {
        if(medicalEntriesRepository.existsById(id)) {
            medicalEntriesRepository.deleteById(id);
        } else {
            throw new RuntimeException("Medical Entry not found with ID: " + id);
        }
    }

    @Override
    public List<MedicalEntriesDto> getMedicalEntryByeEmployeeId(Long employeeId) {
        return medicalEntriesRepository.findAllByDependant_Employee_EmpId(employeeId).stream()
                .map(medicalEntry -> modelMapper.map(medicalEntry, MedicalEntriesDto.class))
                .toList();
    }

    @Override
    public MedicalEntriesDto updateMedicalEntry(Long dependantId, MultipartFile medicalFiles, Double requestAmount, Long medicalEntryId) throws IOException {
        Dependant dependant = dependantsRepository.findById(dependantId)
                .orElseThrow(() -> new RuntimeException("Dependant not found with ID: " + dependantId));

        MedicalEntries medicalEntry = medicalEntriesRepository.findById(medicalEntryId)
                .orElseThrow(() -> new RuntimeException("Medical Entry not found with medicalEntryId: " + medicalEntryId));

        medicalEntry.setDependant(dependant);
        medicalEntry.setMedicalFiles(medicalFiles.getBytes());
        medicalEntry.setRequestAmount(requestAmount);
        return modelMapper.map(medicalEntriesRepository.save(medicalEntry), MedicalEntriesDto.class);
    }


}