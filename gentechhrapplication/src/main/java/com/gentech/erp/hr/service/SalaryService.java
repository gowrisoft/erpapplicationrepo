package com.gentech.erp.hr.service;

import com.gentech.erp.hr.dto.SalaryDto;

import java.util.List;

public interface SalaryService {

    SalaryDto saveSalary(SalaryDto salary);

    List<SalaryDto> getAllSalaries();

    SalaryDto getSalaryByEmployeeId(Long empId) throws Exception;

    SalaryDto updateItem(SalaryDto upd, Long id) throws Exception;

    void deleteItemById(Long id);
}
