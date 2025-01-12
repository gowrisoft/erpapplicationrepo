package com.gentech.erp.hr.dto;

import java.sql.Date;
import com.gentech.erp.hr.entity.Employee;
import com.gentech.erp.hr.entity.JoiningReport;

public class PrintJoiningReportsDto {
    private Long printId;
    private String status;
    private Date printDate;
    private JoiningReport printJoiningId;
    private Employee printadminId;
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

    public JoiningReport getPrintJoiningId() {
        return printJoiningId;
    }

    public void setPrintJoiningId(JoiningReport printJoiningId) {
        this.printJoiningId = printJoiningId;
    }

    public Employee getPrintadminId() {
        return printadminId;
    }

    public void setPrintadminId(Employee printadminId) {
        this.printadminId = printadminId;
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

    public PrintJoiningReportsDto()
    {

    }

    public PrintJoiningReportsDto(Long printId, String status, Date printDate, JoiningReport printJoiningId,
                                  Employee printadminId,Employee printempId,String empName) {
        super();
        this.printId = printId;
        this.status = status;
        this.printDate = printDate;
        this.printJoiningId = printJoiningId;
        this.printadminId = printadminId;
        this.printempId=printempId;
        this.empName = empName;
    }

}
