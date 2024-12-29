package com.gentech.erp.hr.service;

import com.gentech.erp.hr.dto.DependantDto;

import java.util.List;

public interface DependantService {

    DependantDto saveDependant(DependantDto employee);

    List<DependantDto> getAllDependant();


    DependantDto getDependantById(Long dependantId) throws Exception;


    DependantDto updateItem(DependantDto upd, Long id) throws Exception;

    void deleteItemById(Long id);
}
