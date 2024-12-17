package com.gentech.erp.hr.service;

import java.util.List;

import com.gentech.erp.hr.dto.AdminDto;

public interface AdminService {
    AdminDto addAdmin(AdminDto adminDto);
    List<AdminDto> getAllAdmin();
    AdminDto getAdminById(int id);
    String deleteAdminById(int id);
}