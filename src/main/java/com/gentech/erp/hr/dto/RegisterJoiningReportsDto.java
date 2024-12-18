package com.gentech.erp.hr.dto;

import com.gentech.erp.hr.entity.Admin;
import com.gentech.erp.hr.entity.JoiningReport;

import java.sql.Date;

public class RegisterJoiningReportsDto {
    private Long registerId;
    private Date recordDate;
    private JoiningReport regJoiningId;
    private Admin verifiedByAdminId;

    public JoiningReport getRegJoiningId() {
        return regJoiningId;
    }

    public void setRegJoiningId(JoiningReport regJoiningId) {
        this.regJoiningId = regJoiningId;
    }

    public Admin getVerifiedByAdminId() {
        return verifiedByAdminId;
    }

    public void setVerifiedByAdminId(Admin verifiedByAdminId) {
        this.verifiedByAdminId = verifiedByAdminId;
    }

    public Long getRegisterId() {
        return registerId;
    }

    public void setRegisterId(Long registerId) {
        this.registerId = registerId;
    }

    public Date getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(Date recordDate) {
        this.recordDate = recordDate;
    }
    
    public RegisterJoiningReportsDto(){

    }

    public RegisterJoiningReportsDto(Long registerId, Date recordDate, JoiningReport regJoiningId, Admin verifiedByAdminId) {
        this.registerId = registerId;
        this.recordDate = recordDate;
        this.regJoiningId = regJoiningId;
        this.verifiedByAdminId = verifiedByAdminId;
    }
}
