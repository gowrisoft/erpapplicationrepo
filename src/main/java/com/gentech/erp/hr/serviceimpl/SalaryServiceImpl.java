package com.gentech.erp.hr.serviceimpl;


import com.gentech.erp.hr.dto.SalaryDto;
import com.gentech.erp.hr.entity.Salary;
import com.gentech.erp.hr.mapper.SalaryMapper;
import com.gentech.erp.hr.repository.SalaryRepository;
import com.gentech.erp.hr.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SalaryServiceImpl implements SalaryService {

    @Autowired
    private SalaryRepository salaryRepository;

    @Override
    public SalaryDto saveSalary(SalaryDto salary) {
        Salary obj = SalaryMapper.DtoToObject(salary);
        salaryRepository.save(obj);
        salary= SalaryMapper.DtoToObject(obj);
        return salary;
    }

    @Override
    public List<SalaryDto> getAllSalaries() {
        List<Salary> obj=salaryRepository.findAll();
        List<SalaryDto> objDto= new ArrayList<>();
        for(int i=0;i<obj.size();i++)
        {
            objDto.add(SalaryMapper.DtoToObject(obj.get(i)));
        }
        return objDto;
    }

    @Override
    public SalaryDto getSalaryByEmployeeId(Long empId) throws Exception{
        Optional<Salary> obj= salaryRepository.findById(empId);
        if(obj.isPresent())
        {
            SalaryDto dto = SalaryMapper.DtoToObject(obj.get());
            return dto;

        }
        throw new Exception("The item is not present");
    }

    @Override
    public SalaryDto updateItem(SalaryDto upd, Long id) throws Exception{
        Optional<Salary> obj=salaryRepository.findById(id);
        if(obj.isPresent())
        {
            Salary n = obj.get();
            n.setBasicSalary(upd.getBasicSalary());
            n.setEmployee(upd.getEmployee());
            n.setMedicalClaim(upd.getMedicalClaim());
            n.setSalId(id);


            salaryRepository.save(n);
            upd=SalaryMapper.DtoToObject(n);
            return upd;
        }
        throw new Exception("The item is not present");
    }

    @Override
    public void deleteItemById(Long id) {
        salaryRepository.deleteById(id);

    }

}

