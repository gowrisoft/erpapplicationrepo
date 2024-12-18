package com.gentech.erp.hr.serviceimpl;

import com.gentech.erp.hr.dto.EmployeeMedicalCardDto;
import com.gentech.erp.hr.entity.EmployeeMedicalCard;
import com.gentech.erp.hr.mapper.EmployeeMedicalCardMapper;
import com.gentech.erp.hr.repository.EmployeeMedicalCardRepository;
import com.gentech.erp.hr.service.EmployeeMedicalCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeMedicalCardServiceImpl implements EmployeeMedicalCardService {

    @Autowired
    private EmployeeMedicalCardRepository employeeRep;

    @Override
    public List<EmployeeMedicalCardDto> getAllEmployeeMedicalCard() {
        List<EmployeeMedicalCard> obj=employeeRep.findAll();
        List<EmployeeMedicalCardDto> objDto= new ArrayList<>();
        for(int i=0;i<obj.size();i++)
        {
            objDto.add(EmployeeMedicalCardMapper.ObjectToDto(obj.get(i)));
        }
        return objDto;
    }

    @Override
    public EmployeeMedicalCardDto saveEmployeeMedicalCard(EmployeeMedicalCardDto employee) {
        EmployeeMedicalCard obj = EmployeeMedicalCardMapper.DtoToObject(employee);
        employeeRep.save(obj);
        employee=EmployeeMedicalCardMapper.ObjectToDto(obj);
        return employee;
    }

    @Override
    public EmployeeMedicalCardDto getEmployeeMedicalCardByECard(String eCard) throws Exception {
        Optional<EmployeeMedicalCard> obj= employeeRep.findById(eCard);
        if(obj.isPresent())
        {
            EmployeeMedicalCardDto dto = EmployeeMedicalCardMapper.ObjectToDto(obj.get());
            return dto;

        }
        throw new Exception("The item is not present");
    }


    @Override
    public EmployeeMedicalCardDto updateItem(EmployeeMedicalCardDto upd, String id) throws Exception{
        Optional<EmployeeMedicalCard> obj=employeeRep.findById(id);
        if(obj.isPresent())
        {
            EmployeeMedicalCard n = obj.get();
            n.setDependants(upd.getDependants());
            n.seteCard(upd.geteCard());
            n.setEmployee(upd.getEmployee());
            employeeRep.save(n);
            upd=EmployeeMedicalCardMapper.ObjectToDto(n);
            return upd;
        }
        throw new Exception("The item is not present");
    }

    @Override
    public void deleteItemById(String id) {
        employeeRep.deleteById(id);

    }
}
