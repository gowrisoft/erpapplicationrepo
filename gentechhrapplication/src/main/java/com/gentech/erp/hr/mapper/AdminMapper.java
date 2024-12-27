package com.gentech.erp.hr.mapper;

import com.gentech.erp.hr.dto.AdminDto;
import com.gentech.erp.hr.entity.Admin;

public class AdminMapper {
    public static AdminDto mapAdminToAdminDto(Admin adminEntity) {
        AdminDto adminDto = new AdminDto(
                adminEntity.getAdminId(),
                adminEntity.getAdminName(),
                adminEntity.getAdminPhone()
        );
        return adminDto;
    }

    public static Admin mapAdminDtoToAdmin(AdminDto adminDto) {
        Admin adminEntity = new Admin(
                adminDto.getAdminId(),
                adminDto.getAdminName(),
                adminDto.getAdminPhone(),
                null
        );
        return adminEntity;
    }
}
