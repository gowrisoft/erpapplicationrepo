package com.gentech.erp.hr.entity;
import java.sql.Date;
import jakarta.persistence.*;

@Entity
@Table(name = "tbl_joining_report")
public class JoiningReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "joining_id")
    private Long joiningId;

    @Column(name = "employee_name")
    private String empName;

    @Column(name = "designation")
    private String designation;

    @Column(name = "status")
    private String status;

    @Column(name = "joining_date")
    private Date joiningDate;


    @OneToOne (cascade=CascadeType.ALL)
    @JoinColumn(name = "joining_emp_id", referencedColumnName = "Emp_id")
    private Employee joiningEmployee;

    @ManyToOne
    @JoinColumn(name = "reporting_manager", referencedColumnName = "Emp_id")
    private Employee reportingManager;

    @ManyToOne
    @JoinColumn(name = "verified_by_admin_id", referencedColumnName = "admin_id")
    private Admin joinadminId;


    public JoiningReport() {}


    public JoiningReport(Long joiningId, String empName, String designation, String status, Date joiningDate,
                         Employee joiningEmployee,Admin joinadminId,Employee reportingManager) {
        this.joiningId = joiningId;
        this.empName = empName;
        this.designation = designation;
        this.status = status;
        this.joiningDate = joiningDate;
        this.joiningEmployee = joiningEmployee;
        this.joinadminId=joinadminId;
        this.reportingManager=reportingManager;
    }

    // Getters and Setters
    public Long getJoiningId() {
        return joiningId;
    }

    public void setJoiningId(Long joiningId) {
        this.joiningId = joiningId;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }

    public Employee getJoiningEmployee() {
        return joiningEmployee;
    }

    public void setJoiningEmployee(Employee joiningEmployee) {
        this.joiningEmployee = joiningEmployee;
    }

    public Admin getJoinadminId() {
        return joinadminId;
    }

    public void setJoinadminId(Admin joinadminId) {
        this.joinadminId=joinadminId;
    }

    public Employee getReportingManager() {
        return reportingManager;
    }

    public void setReportingManager(Employee reportingManager) {
        this.reportingManager=reportingManager;
    }
}
