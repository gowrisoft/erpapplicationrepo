package com.gentech.erp.hr.dto;

import com.gentech.erp.hr.entity.Admin;
import com.gentech.erp.hr.entity.RelievingReport;

import java.sql.Date;

public class PrintRelievingReportsDto {
    private Long printId;
    private String status;
    private Date printDate;
    private RelievingReport printRelievingId;
    private Admin printadminId;

    public PrintRelievingReportsDto() {

    }

    public PrintRelievingReportsDto(Long printId, String status, Date printDate, RelievingReport printRelievingId,
                                    Admin printadminId) {
        super();
        this.printId = printId;
        this.status = status;
        this.printDate = printDate;
        this.printRelievingId = printRelievingId;
        this.printadminId = printadminId;
    }

    public Long getPrintId() {
        return printId;
    }

    public void setPrintId(Long printId) {
        this.printId = printId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getPrintDate() {
        return printDate;
    }

    public void setPrintDate(Date printDate) {
        this.printDate = printDate;
    }

    public RelievingReport getPrintRelievingId() {
        return printRelievingId;
    }

    public void setPrintRelievingId(RelievingReport printRelievingId) {
        this.printRelievingId = printRelievingId;
    }

    public Admin getPrintadminId() {
        return printadminId;
    }

    public void setPrintadminId(Admin printadminId) {
        this.printadminId = printadminId;
    }


}
