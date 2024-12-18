package com.gentech.erp.hr.mapper;

import com.gentech.erp.hr.dto.RegisterJoiningReportsDto;
import com.gentech.erp.hr.entity.RegisterJoiningReports;

public class RegisterJoiningReportsMapper {
    public static RegisterJoiningReportsDto mapRegJoinToRegJoinDto(RegisterJoiningReports registerJoiningReports){
        RegisterJoiningReportsDto registerJoiningReportsDto=new RegisterJoiningReportsDto(
                registerJoiningReports.getRegisterId(),
                registerJoiningReports.getRecordDate(),
                registerJoiningReports.getRegJoiningId(),
                registerJoiningReports.getverifiedByAdminId()
                
                
        );
        return registerJoiningReportsDto;
    }
    public static RegisterJoiningReports mapRegJoinDtoToRegJoin(RegisterJoiningReportsDto registerJoiningReportsDto){
        RegisterJoiningReports registerJoiningReports=new RegisterJoiningReports(
                registerJoiningReportsDto.getRegisterId(),
                registerJoiningReportsDto.getRecordDate(),
                registerJoiningReportsDto.getRegJoiningId(),
                registerJoiningReportsDto.getVerifiedByAdminId()
        );
        return registerJoiningReports;
    }
}
