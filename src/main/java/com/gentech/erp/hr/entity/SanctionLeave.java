package com.gentech.erp.hr.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "sanction_leave")
public class SanctionLeave {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sanction_id")
    private int sanctionId;

    @Column(name = "application_status", nullable = false)
    @Enumerated(EnumType.STRING)
    private ApplicationStatus applicationStatus;

    @Column(name = "sanction_date", nullable = false)
    private LocalDateTime sanctionDate;

    @OneToOne
    @JoinColumn(name = "leave_req_id", referencedColumnName = "leave_req_id", nullable = true)
    private LeaveApplication leaveApplication;

    @OneToOne
    @JoinColumn(name = "compensatory_leave_id", referencedColumnName = "compensatory_leave_id", nullable = true)
    private CompensatoryLeave compensatoryLeave;

    @ManyToOne
    @JoinColumn(name = "admin_id", referencedColumnName = "admin_id", nullable = false)
    private Admin admin;

    public SanctionLeave() {}

    public SanctionLeave(int sanctionId, ApplicationStatus applicationStatus, LocalDateTime sanctionDate, LeaveApplication leaveApplication, CompensatoryLeave compensatoryLeave, Admin admin) {
        this.sanctionId = sanctionId;
        this.applicationStatus = applicationStatus;
        this.sanctionDate = sanctionDate;
        this.leaveApplication = leaveApplication;
        this.compensatoryLeave = compensatoryLeave;
        this.admin = admin;
    }

    public int getSanctionId() {
        return sanctionId;
    }

    public void setSanctionId(int sanctionId) {
        this.sanctionId = sanctionId;
    }

    public ApplicationStatus getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(ApplicationStatus applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    public LocalDateTime getSanctionDate() {
        return sanctionDate;
    }

    public void setSanctionDate(LocalDateTime sanctionDate) {
        this.sanctionDate = sanctionDate;
    }

    public LeaveApplication getLeaveApplication() {
        return leaveApplication;
    }

    public void setLeaveApplication(LeaveApplication leaveApplication) {
        this.leaveApplication = leaveApplication;
    }

    public CompensatoryLeave getCompensatoryLeave() {
        return compensatoryLeave;
    }

    public void setCompensatoryLeave(CompensatoryLeave compensatoryLeave) {
        this.compensatoryLeave = compensatoryLeave;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    @PrePersist
    private void onSanction() {
        this.sanctionDate = LocalDateTime.now();
    }

    public enum ApplicationStatus {
        APPROVED,
        REJECTED
    }
}
