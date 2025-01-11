package com.gentech.erp.hr.entity;

import java.sql.Date;
import jakarta.persistence.*;

@Entity
@Table(name = "tbl_print_relieving_report")
public class PrintRelievingReports{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "print_id")
    private Long printId;

    @Column(name = "print_date")
    private Date printDate;

    @ManyToOne
    @JoinColumn(name = "print_Relieving_id", referencedColumnName = "relieving_id")
    private RelievingReport printRelievingId;

    @ManyToOne
    @JoinColumn(name = "print_admin_id", referencedColumnName = "admin_id")
    private Admin printadminId;


    @ManyToOne
    @JoinColumn(name = "print_Joining_id", referencedColumnName = "joining_id")
    private JoiningReport printJoiningId;

    @ManyToOne
    @JoinColumn(name = "print_emp_id", referencedColumnName = "Emp_id")
    private Employee printempId;

    @Column(name = "employee_name")
    private String empName;

    @Column(name = "status")
    private String status;

    public PrintRelievingReports() {

    }


    public PrintRelievingReports(Date printDate, RelievingReport printRelievingId, Admin printadminId, String status,JoiningReport printJoiningId,Employee printempId, String empName) {
        super();
        this.printDate = printDate;
        this.printRelievingId = printRelievingId;
        this.printadminId = printadminId;
        this.status = status;
        this.printJoiningId=printJoiningId;
        this.printempId=printempId;
        this.empName= empName;
    }

    public PrintRelievingReports(Long printId, Date printDate, RelievingReport printRelievingId, Admin printadminId, String status,JoiningReport printJoiningId,Employee printempId, String empName) {
        this.printId = printId;
        this.printDate = printDate;
        this.printRelievingId = printRelievingId;
        this.printadminId = printadminId;
        this.status = status;
        this.printJoiningId=printJoiningId;
        this.printempId=printempId;
        this.empName= empName;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
}
