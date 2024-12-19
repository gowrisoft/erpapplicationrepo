package com.gentech.erp.hr.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class ApprovedMedicalClaim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long claimId;

    @OneToOne
    @JoinColumn(name = "MRno", referencedColumnName = "MRno", nullable = false)
    private MedicalEntries medicalEntry;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @Column(nullable = false)
    private Double approvedAmount;

    @Column(nullable = false)
    private LocalDate approvalDate;

    public ApprovedMedicalClaim(Long claimId, MedicalEntries medicalEntry, Employee employee, Double approvedAmount, LocalDate approvalDate) {
        this.claimId = claimId;
        this.medicalEntry = medicalEntry;
        this.employee = employee;
        this.approvedAmount = approvedAmount;
        this.approvalDate = approvalDate;
    }

    public ApprovedMedicalClaim() {
    }

    public Long getClaimId() {
        return claimId;
    }

    public void setClaimId(Long claimId) {
        this.claimId = claimId;
    }

    public MedicalEntries getMedicalEntry() {
        return medicalEntry;
    }

    public void setMedicalEntry(MedicalEntries medicalEntry) {
        this.medicalEntry = medicalEntry;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Double getApprovedAmount() {
        return approvedAmount;
    }

    public void setApprovedAmount(Double approvedAmount) {
        this.approvedAmount = approvedAmount;
    }

    public LocalDate getApprovalDate() {
        return approvalDate;
    }

    public void setApprovalDate(LocalDate approvalDate) {
        this.approvalDate = approvalDate;
    }
}