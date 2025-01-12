package com.gentech.erp.hr.entity;

import java.sql.Date;
import jakarta.persistence.*;

@Entity
@Table(name = "tbl_print_joining_report")
public class PrintJoiningReports{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "print_id")
    private Long printId;

    @Column(name = "print_date")
    private Date printDate;

    @ManyToOne
    @JoinColumn(name = "print_joining_id", referencedColumnName = "joining_id")
    private JoiningReport printJoiningId;

    @ManyToOne
    @JoinColumn(name = "print_admin_id")
    private Employee printadminId;

    @ManyToOne
    @JoinColumn(name = "print_emp_id", referencedColumnName = "Emp_id")
    private Employee printempId;

    @Column(name = "status")
    private String status;

    @Column(name = "employee_name")
    private String empName;

    public PrintJoiningReports() {

    }

    public PrintJoiningReports(Date printDate, JoiningReport printJoiningId, Employee printadminId, String status,Employee printempId,String empName
    ) {
        super();
        this.printDate = printDate;
        this.printJoiningId = printJoiningId;
        this.printadminId = printadminId;
        this.status = status;
        this.printempId=printempId;
        this.empName = empName;
    }

    public PrintJoiningReports(Long printId, Date printDate, JoiningReport printJoiningId, Employee printadminId, String status,Employee printempId,String empName) {
        this.printId = printId;
        this.printDate = printDate;
        this.printJoiningId = printJoiningId;
        this.printadminId = printadminId;
        this.status = status;
        this.printempId=printempId;
        this.empName = empName;
    }

    public Long getPrintId() {
        return printId;
    }

    public void setPrintId(Long printId) {
        this.printId = printId;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

}
