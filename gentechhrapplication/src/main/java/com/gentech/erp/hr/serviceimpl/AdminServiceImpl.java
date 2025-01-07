package com.gentech.erp.hr.serviceimpl;

import com.gentech.erp.hr.dto.AdminDto;
import com.gentech.erp.hr.entity.Admin;
import com.gentech.erp.hr.exception.ResourceNotFoundException;
import com.gentech.erp.hr.mapper.AdminMapper;
import com.gentech.erp.hr.repository.AdminRepository;
import com.gentech.erp.hr.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminRepository adminRepository;

    @Override
    public AdminDto addAdmin(AdminDto adminDto) {
        Admin adminEntity = AdminMapper.mapAdminDtoToAdmin(adminDto);
        adminRepository.save(adminEntity);
        AdminDto adminDto1 = AdminMapper.mapAdminToAdminDto(adminEntity);
        return adminDto1;
    }

    @Override
    public List<AdminDto> getAllAdmin() {
        return adminRepository.findAll()
                .stream()
                .map((admin) -> AdminMapper.mapAdminToAdminDto(admin))
                .toList();
    }

    @Override
    public AdminDto getAdminById(int id) {
        Admin adminEntity = adminRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Admin", "Admin id", id));

        return AdminMapper.mapAdminToAdminDto(adminEntity);
    }

    @Override
    @Transactional
    public String deleteAdminById(int id) {
        Admin adminEntity = adminRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Admin", "Admin id", id));

        if (adminEntity == null) {
            return "Admin with admin id : " + id + " is not found in the database";
        }
        adminRepository.deleteById(id);
        return "Admin with admin id : " + id + " is successfully deleted in the database";
    }
}
