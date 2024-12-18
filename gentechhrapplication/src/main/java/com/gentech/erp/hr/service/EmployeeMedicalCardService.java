package com.gentech.erp.hr.service;

import com.gentech.erp.hr.dto.EmployeeMedicalCardDto;

import java.util.List;

public interface EmployeeMedicalCardService {

    List<EmployeeMedicalCardDto> getAllEmployeeMedicalCard();

    EmployeeMedicalCardDto saveEmployeeMedicalCard(EmployeeMedicalCardDto employee);


    EmployeeMedicalCardDto getEmployeeMedicalCardByECard(String eCard)  throws Exception;



    EmployeeMedicalCardDto updateItem(EmployeeMedicalCardDto upd, String id)throws Exception;

    void deleteItemById(String id);
}