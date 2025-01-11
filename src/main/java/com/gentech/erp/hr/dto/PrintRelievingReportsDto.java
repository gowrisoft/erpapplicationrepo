package com.gentech.erp.hr.dto;

import java.sql.Date;


import com.gentech.erp.hr.entity.Admin;
import com.gentech.erp.hr.entity.Employee;
import com.gentech.erp.hr.entity.JoiningReport;
import com.gentech.erp.hr.entity.RelievingReport;

public class PrintRelievingReportsDto {
    private Long printId;
    private String status;
    private Date printDate;
    private RelievingReport printRelievingId;
    private Admin printadminId;
    private JoiningReport printJoiningId;
    private Employee printempId;
    private String empName;

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

    public JoiningReport getPrintJoiningId()
    {
        return printJoiningId;
    }

    public void serPrintJoiningId(JoiningReport printJoiningId) {
        this.printJoiningId=printJoiningId;
    }

    public Employee getPrintempId() {
        return printempId;
    }

    public void setPrintempId(Employee printempId) {
        this.printempId=printempId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }


    public PrintRelievingReportsDto()
    {

    }

    public PrintRelievingReportsDto(Long printId, String status, Date printDate, RelievingReport printRelievingId,
                                    Admin printadminId,JoiningReport printJoiningId,Employee printempId, String empName) {
        super();
        this.printId = printId;
        this.status = status;
        this.printDate = printDate;
        this.printRelievingId = printRelievingId;
        this.printadminId = printadminId;
        this.printJoiningId=printJoiningId;
        this.printempId=printempId;
        this.empName= empName;
    }


}
