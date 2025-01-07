package com.gentech.erp.hr.entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "tbl_relieving_report")
public class RelievingReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "relieving_id")
    private Long relievingId;

    @Column(name = "employee_name")
    private String empName;

    @Column(name = "designation")
    private String designation;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "relieving_emp_id", referencedColumnName = "Emp_id")
    private Employee relievingEmployee;

    @Column(name = "reason")
    private String reason;

    @Column(name = "status")
    private String status;

    @Column(name = "relieving_date")
    private Date relievingDate;


    // Constructors
    public RelievingReport() {
    }

    public RelievingReport(Long relievingId, String empName, String designation, Employee relievingEmployee, String reason, String status, Date relievingDate) {
        this.relievingId = relievingId;
        this.empName = empName;
        this.designation = designation;
        this.relievingEmployee = relievingEmployee;
        this.reason = reason;
        this.status = status;
        this.relievingDate = relievingDate;
    }

    public RelievingReport(String empName, String designation, Employee relievingEmployee, Employee reportingManager,
                           String status, Date relievingDate, String reason) {
        this.empName = empName;
        this.designation = designation;
        this.relievingEmployee = relievingEmployee;
        this.reason = reason;
        this.status = status;
        this.relievingDate = relievingDate;
    }

    public Long getRelievingId() {
        return relievingId;
    }

    public void setRelievingId(Long relievingId) {
        this.relievingId = relievingId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Employee getRelievingEmployee() {
        return relievingEmployee;
    }

    public void setRelievingEmployee(Employee relievingEmployee) {
        this.relievingEmployee = relievingEmployee;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getRelievingDate() {
        return relievingDate;
    }

    public void setRelievingDate(Date relievingDate) {
        this.relievingDate = relievingDate;
    }
}
