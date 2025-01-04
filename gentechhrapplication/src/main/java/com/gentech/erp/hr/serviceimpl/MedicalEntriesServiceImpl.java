package com.gentech.erp.hr.serviceimpl;


import com.gentech.erp.hr.dto.MedicalEntriesDto;
import com.gentech.erp.hr.entity.Dependant;
import com.gentech.erp.hr.entity.Employee;
import com.gentech.erp.hr.entity.MedicalEntries;
import com.gentech.erp.hr.exception.ResourceNotFoundException;
import com.gentech.erp.hr.mapper.MedicalEntriesMapper;
import com.gentech.erp.hr.repository.DependantsRepository;
import com.gentech.erp.hr.repository.EmployeeRepository;
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
    public MedicalEntriesDto getMedicalEntryByMRno(Long MRno) throws Exception {
        Optional<MedicalEntries> obj = medicalEntriesRepository.findById(MRno);
        if (obj.isPresent()) {
            MedicalEntriesDto dto = MedicalEntriesMapper.objectToDto(obj.get());
            return dto;

        }
        throw new Exception("The item is not present");
    }



    @Override
    public void deleteItemById(Long id) {
        medicalEntriesRepository.deleteById(id);

    }

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<MedicalEntriesDto> getMedicalEntryByeEmployeeId(Long mRno) {
        Employee dto= employeeRepository.findById(mRno)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found"));

        List<Dependant> dtolist=dependantsRepository.findAll();

        List<Dependant> sendList=new ArrayList<>();
        for(Dependant a:dtolist)
        {
            if(a.getEmployee() == dto)
            {
                sendList.add(a);
            }
        }


        List<MedicalEntries> obj = medicalEntriesRepository.findAll();
        List<MedicalEntriesDto> objDto = new ArrayList<>();
        for (int i = 0; i < obj.size(); i++) {
            objDto.add(MedicalEntriesMapper.objectToDto(obj.get(i)));
        }

        List<MedicalEntriesDto> finalList = new ArrayList<>();
        for(MedicalEntriesDto b : objDto)
        {
            for(Dependant a:sendList)
            {
                if(b.getDependant().equals(a))
                {
                    finalList.add(b);
                }
            }
        }
        return finalList;
    }

    @Override
    public void updateItem(Long dependantId, MultipartFile medicalFiles, Double requestAmount, Long medicalEntryId) throws Exception {
        Dependant dependant = dependantsRepository.findById(dependantId)
                .orElseThrow(() -> new RuntimeException("Dependant not found with ID: " + dependantId));

        MedicalEntries medicalEntry = medicalEntriesRepository.findById(medicalEntryId)
                .orElseThrow(() -> new RuntimeException("Medical Entry not found with medicalEntryId: " + medicalEntryId));

        medicalEntry.setDependant(dependant);
        medicalEntry.setMedicalFiles(medicalFiles.getBytes());
        medicalEntry.setRequestAmount(requestAmount);

        medicalEntriesRepository.save(medicalEntry);
    }


}