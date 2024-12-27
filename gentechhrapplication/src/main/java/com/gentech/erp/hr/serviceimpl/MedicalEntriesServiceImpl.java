package com.gentech.erp.hr.serviceimpl;


import com.gentech.erp.hr.dto.MedicalEntriesDto;
import com.gentech.erp.hr.entity.Dependants;
import com.gentech.erp.hr.entity.Employee;
import com.gentech.erp.hr.entity.MedicalEntries;
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
    private EmployeeRepository employeeRepository;

    @Autowired
    private DependantsRepository dependantsRepository;

    @Override
    public void saveMedicalEntry(Long empId, Long dependantId,
                                 MultipartFile medicalFiles, Double requestAmount) throws IOException {
        Employee employee = employeeRepository.findById(empId)
                .orElseThrow(() -> new RuntimeException("Employee not found with ID: " + empId));
        Dependants dependants = dependantsRepository.findById(dependantId)
                .orElseThrow(() -> new RuntimeException("Dependant not found with ID: " + dependantId));

        MedicalEntries medicalEntry = new MedicalEntries();
        medicalEntry.setEmployee(employee);
        medicalEntry.setDependants(dependants);
        medicalEntry.setMedicalFiles(medicalFiles.getBytes());
        medicalEntry.setRequestAmount(requestAmount);

        medicalEntriesRepository.save(medicalEntry);

    }

    @Override
    public List<MedicalEntriesDto> getAllMedicalEntries() {
        List<MedicalEntries> obj = medicalEntriesRepository.findAll();
        List<MedicalEntriesDto> objDto = new ArrayList<>();
        for (int i = 0; i < obj.size(); i++) {
            objDto.add(MedicalEntriesMapper.ObjectToDto(obj.get(i)));
        }
        return objDto;
    }

    @Override
    public MedicalEntriesDto getMedicalEntryByMRno(Long MRno) throws Exception {
        Optional<MedicalEntries> obj = medicalEntriesRepository.findById(MRno);
        if (obj.isPresent()) {
            MedicalEntriesDto dto = MedicalEntriesMapper.ObjectToDto(obj.get());
            return dto;

        }
        throw new Exception("The item is not present");
    }

    @Override
    public MedicalEntriesDto updateItem(MedicalEntriesDto upd, Long id) throws Exception {
        Optional<MedicalEntries> obj = medicalEntriesRepository.findById(id);
        if (obj.isPresent()) {
            MedicalEntries n = obj.get();
            n.setDependants(upd.getDependants());
            n.setEmployee(upd.getEmployee());
            n.setMedicalFiles(upd.getMedicalFiles());
            n.setMRno(upd.getMRno());
            n.setRequestAmount(upd.getRequestAmount());

            medicalEntriesRepository.save(n);
            upd = MedicalEntriesMapper.ObjectToDto(n);
            return upd;
        }
        throw new Exception("The item is not present");
    }

    @Override
    public void deleteItemById(Long id) {
        medicalEntriesRepository.deleteById(id);

    }
}