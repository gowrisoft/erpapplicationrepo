package com.gentech.erp.hr.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "apply_leave")
public class LeaveApplication {
	public LeaveApplication(){

	}
    public LeaveApplication(int leaveRequestId, Date startDate, Date endDate, String reason, String empName,
			String typeOfLeave, Employee employee, ModifyLeave modifyLeave, SanctionLeave sanctionLeave,
			List<LeaveLedger> leaveLedgers) {
		super();
		this.leaveRequestId = leaveRequestId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.reason = reason;
		this.empName = empName;
		this.typeOfLeave = typeOfLeave;
		this.employee = employee;
		this.modifyLeave = modifyLeave;
		this.sanctionLeave = sanctionLeave;
		this.leaveLedgers = leaveLedgers;
	}

	public int getLeaveRequestId() {
		return leaveRequestId;
	}

	public void setLeaveRequestId(int leaveRequestId) {
		this.leaveRequestId = leaveRequestId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getTypeOfLeave() {
		return typeOfLeave;
	}

	public void setTypeOfLeave(String typeOfLeave) {
		this.typeOfLeave = typeOfLeave;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public ModifyLeave getModifyLeave() {
		return modifyLeave;
	}

	public void setModifyLeave(ModifyLeave modifyLeave) {
		this.modifyLeave = modifyLeave;
	}

	public SanctionLeave getSanctionLeave() {
		return sanctionLeave;
	}

	public void setSanctionLeave(SanctionLeave sanctionLeave) {
		this.sanctionLeave = sanctionLeave;
	}

	public List<LeaveLedger> getLeaveLedgers() {
		return leaveLedgers;
	}

	public void setLeaveLedgers(List<LeaveLedger> leaveLedgers) {
		this.leaveLedgers = leaveLedgers;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "leave_req_id")
    private int leaveRequestId;
    @Column(name = "start_date")
    private Date startDate;
    @Column(name = "end_date")
    private Date endDate;
    @Column(name = "reason")
    private String reason;
    @Column(name = "emp_name")
    private String empName;
    @Column(name = "type_of_leave")
    private String typeOfLeave;
    @ManyToOne
    @JoinColumn(name = "emp_id", nullable = false)
    private Employee employee;

    @OneToOne(mappedBy = "leaveApplication", cascade = CascadeType.ALL, orphanRemoval = true)
    private ModifyLeave modifyLeave;

    @OneToOne(mappedBy = "leaveApplication", cascade = CascadeType.ALL, orphanRemoval = true)
    private SanctionLeave sanctionLeave;

    @OneToMany(mappedBy = "leaveApplication",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LeaveLedger> leaveLedgers;
}
