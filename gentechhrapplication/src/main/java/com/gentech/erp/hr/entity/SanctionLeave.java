package com.gentech.erp.hr.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "sanction_leave")
public class SanctionLeave {
	public SanctionLeave(){

	}
    public SanctionLeave(int sanctionId, ApplicationStatus applicationStatus, LocalDateTime sanctionDate,
			LeaveApplication leaveApplication, Admin admin) {
		super();
		this.sanctionId = sanctionId;
		this.applicationStatus = applicationStatus;
		this.sanctionDate = sanctionDate;
		this.leaveApplication = leaveApplication;
		this.admin = admin;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sanction_id")
    private int sanctionId;

    @Column(name = "application_status",nullable = false)
    @Enumerated(EnumType.STRING)
    private ApplicationStatus applicationStatus;

    @Column(name = "sanction_date",nullable = false)
    private LocalDateTime sanctionDate;

    @OneToOne
    @JoinColumn(name = "leave_req_id", referencedColumnName = "leave_req_id")
    private LeaveApplication leaveApplication;

    @ManyToOne
    @JoinColumn(name = "admin_id",referencedColumnName = "admin_id")
    private Admin admin;

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

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	@PrePersist
    private void onSanction(){
        this.sanctionDate=LocalDateTime.now();
    }

    public enum ApplicationStatus{
        APPROVED,
        REJECTED
    }
}

