package com.gentech.erp.hr.service;

import com.gentech.erp.hr.dto.AdminDto;

import java.util.List;

public interface AdminService {
    AdminDto addAdmin(AdminDto adminDto);

    List<AdminDto> getAllAdmin();

    AdminDto getAdminById(int id);

    String deleteAdminById(int id);
}