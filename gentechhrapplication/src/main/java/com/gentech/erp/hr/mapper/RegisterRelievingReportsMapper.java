package com.gentech.erp.hr.mapper;

import com.gentech.erp.hr.dto.RegisterRelievingReportsDto;
import com.gentech.erp.hr.entity.RegisterRelievingReports;

public class RegisterRelievingReportsMapper {
    public static RegisterRelievingReportsDto mapRegRelToRegRelDto(RegisterRelievingReports registerRelievingReports) {
        RegisterRelievingReportsDto registerRelievingReportsDto = new RegisterRelievingReportsDto(
                registerRelievingReports.getRegisterId(),
                registerRelievingReports.getRecordDate(),
                registerRelievingReports.getregRelievingId(),
                registerRelievingReports.getverifiedByAdminId()
        );
        return registerRelievingReportsDto;
    }

    public static RegisterRelievingReports mapRegRelDtoToRegRel(RegisterRelievingReportsDto registerRelievingReportsDto) {
        RegisterRelievingReports registerRelievingReports = new RegisterRelievingReports(
                registerRelievingReportsDto.getRegisterId(),
                registerRelievingReportsDto.getRecordDate(),
                registerRelievingReportsDto.getRegRelievingId(),
                registerRelievingReportsDto.getVerifiedByAdminId()

        );
        return registerRelievingReports;
    }
}
