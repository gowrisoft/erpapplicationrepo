package com.gentech.erp.hr.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class ApprovedMedicalClaim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long claimId;

    @OneToOne
    @JoinColumn(name = "medical_entry_id", referencedColumnName = "medicalEntryId", nullable = false)
    private MedicalEntries medicalEntry;

    @Column(nullable = false)
    private Double approvedAmount;

    @Column(nullable = false)
    private LocalDate approvalDate;

    @ManyToOne
    @JoinColumn(name = "admin_id", nullable = false)
    private Employee admin;

    public ApprovedMedicalClaim() {
    }

    public ApprovedMedicalClaim(Long claimId, MedicalEntries medicalEntry, Double approvedAmount, LocalDate approvalDate, Employee admin) {
        this.claimId = claimId;
        this.medicalEntry = medicalEntry;
        this.approvedAmount = approvedAmount;
        this.approvalDate = approvalDate;
        this.admin = admin;
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

    public Employee getAdmin() {
        return admin;
    }

    public void setAdmin(Employee admin) {
        this.admin = admin;
    }
}