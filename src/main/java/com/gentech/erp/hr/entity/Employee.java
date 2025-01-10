package com.gentech.erp.hr.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private long empId;

    @NotNull(message = "First name cannot be null")
    @Size(min = 2, max = 50, message = "First name must be between 2 and 50 characters")
    private String firstName;

    @NotNull(message = "Last name cannot be null")
    @Size(min = 1, max = 50, message = "Last name must be between 2 and 50 characters")
    private String lastName;

    @NotNull(message = "Email cannot be null")
    @Email(message = "Invalid email format")
    private String email;

    @NotNull(message = "Phone number cannot be null")
    @Size(min = 10, max = 15, message = "Phone number must be between 10 and 15 characters")
    private String phoneNumber;

    @NotNull(message = "Base salary cannot be null")
    @Column(nullable = false) // Ensures database-level constraint
    private BigDecimal baseSalary;

    @NotNull(message = "Allowances cannot be null")
    @Column(nullable = false)
    private BigDecimal allowances;

    @NotNull(message = "Date of joining cannot be null")
    @Column(nullable = false)
    private LocalDate dateOfJoining;

    private String empDesignation;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LeaveApplication> leaveApplications;
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LeaveLedger> leaveLedgers;
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CompensatoryLeave> compensatoryLeaveEntities;

    public Employee() {

    }

    public Employee(long empId, String firstName, String lastName, String email, String phoneNumber, BigDecimal baseSalary, BigDecimal allowances, LocalDate dateOfJoining, String empDesignation, List<LeaveApplication> leaveApplications, List<LeaveLedger> leaveLedgers, List<CompensatoryLeave> compensatoryLeaveEntities) {
        this.empId = empId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.baseSalary = baseSalary;
        this.allowances = allowances;
        this.dateOfJoining = dateOfJoining;
        this.empDesignation = empDesignation;
        this.leaveApplications = leaveApplications;
        this.leaveLedgers = leaveLedgers;
        this.compensatoryLeaveEntities = compensatoryLeaveEntities;
    }

    public long getEmpId() {
        return empId;
    }

    public void setEmpId(long empId) {
        this.empId = empId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public BigDecimal getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(BigDecimal baseSalary) {
        this.baseSalary = baseSalary;
    }

    public BigDecimal getAllowances() {
        return allowances;
    }

    public void setAllowances(BigDecimal allowances) {
        this.allowances = allowances;
    }

    public LocalDate getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(LocalDate dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public String getEmpDesignation() {
        return empDesignation;
    }

    public void setEmpDesignation(String empDesignation) {
        this.empDesignation = empDesignation;
    }

    public List<LeaveApplication> getLeaveApplications() {
        return leaveApplications;
    }

    public void setLeaveApplications(List<LeaveApplication> leaveApplications) {
        this.leaveApplications = leaveApplications;
    }

    public List<LeaveLedger> getLeaveLedgers() {
        return leaveLedgers;
    }

    public void setLeaveLedgers(List<LeaveLedger> leaveLedgers) {
        this.leaveLedgers = leaveLedgers;
    }

    public List<CompensatoryLeave> getCompensatoryLeaveEntities() {
        return compensatoryLeaveEntities;
    }

    public void setCompensatoryLeaveEntities(List<CompensatoryLeave> compensatoryLeaveEntities) {
        this.compensatoryLeaveEntities = compensatoryLeaveEntities;
    }
}