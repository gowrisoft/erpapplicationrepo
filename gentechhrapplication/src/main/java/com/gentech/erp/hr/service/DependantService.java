package com.gentech.erp.hr.service;

import com.gentech.erp.hr.dto.DependantsDto;

import java.util.List;

public interface DependantService {

    DependantsDto saveDependant(DependantsDto employee);

    List<DependantsDto> getAllDependant();


    DependantsDto getDependantById(Long dependantId) throws Exception;


    DependantsDto updateItem(DependantsDto upd, Long id) throws Exception;

    void deleteItemById(Long id);
}
