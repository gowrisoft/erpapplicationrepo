package com.gentech.erp.hr.dto;

import com.gentech.erp.hr.entity.Admin;
import com.gentech.erp.hr.entity.RelievingReport;

import java.sql.Date;

public class RegisterRelievingReportsDto {
    private Long registerId;
    private Date recordDate;
    private RelievingReport regRelievingId;
    private Admin verifiedByAdminId;


    public RegisterRelievingReportsDto() {

    }

    public RegisterRelievingReportsDto(Long registerId, Date recordDate, RelievingReport regRelievingId, Admin verifiedByAdminId) {
        this.registerId = registerId;
        this.recordDate = recordDate;
        this.regRelievingId = regRelievingId;
        this.verifiedByAdminId = verifiedByAdminId;
    }

    public RelievingReport getRegRelievingId() {
        return regRelievingId;
    }

    public void setRegRelievingId(RelievingReport regRelievingId) {
        this.regRelievingId = regRelievingId;
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
}
