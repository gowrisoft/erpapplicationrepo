package com.gentech.erp.hr.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private Long empId;

    @NotNull(message = "First name cannot be null")
    @Size(min = 2, max = 50, message = "First name must be between 2 and 50 characters")
    private String firstName;

    @NotNull(message = "Last name cannot be null")
    @Size(min = 1, max = 50, message = "Last name must be between 2 and 50 characters")
    private String lastName;

    @NotNull(message = "Email cannot be null")
    @Email(message = "Invalid email format")
    @Column(unique = true)
    private String email;

    @NotNull(message = "Phone number cannot be null")
    @Size(min = 10, max = 15, message = "Phone number must be between 10 and 15 characters")
    private String phoneNumber;

    @NotNull(message = "Gender cannot be null")
    @Size(min = 4, max = 6, message = "Gender must be between 4 and 6 characters long")
    @Pattern(regexp = "Male|Female|Other", message = "Gender must be Male, Female, or Other")
    private String gender;

    @NotNull(message = "Date of Birth cannot be null")
    @Column(nullable = false)
    private LocalDate dateOfBirth;

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
    @JsonIgnore
    private List<LeaveApplication> leaveApplications;
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<LeaveLedger> leaveLedgers;
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<CompensatoryLeave> compensatoryLeaveEntities;

    public Employee() {

    }

    public Employee(Long empId, String firstName, String lastName, String email, String phoneNumber, String gender, LocalDate dateOfBirth, BigDecimal baseSalary, BigDecimal allowances, LocalDate dateOfJoining, String empDesignation, List<LeaveApplication> leaveApplications, List<LeaveLedger> leaveLedgers, List<CompensatoryLeave> compensatoryLeaveEntities) {
        this.empId = empId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.baseSalary = baseSalary;
        this.allowances = allowances;
        this.dateOfJoining = dateOfJoining;
        this.empDesignation = empDesignation;
        this.leaveApplications = leaveApplications;
        this.leaveLedgers = leaveLedgers;
        this.compensatoryLeaveEntities = compensatoryLeaveEntities;
    }

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
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