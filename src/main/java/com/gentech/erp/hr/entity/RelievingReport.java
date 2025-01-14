package com.gentech.erp.hr.entity;
import java.sql.Date;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tbl_relieving_report")
public class RelievingReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "relieving_id")
    private Long relievingId;

    @NotNull(message = "First name cannot be null")
    @Size(min = 2, max = 50, message = "First name must be between 2 and 50 characters")
    private String firstName;

    @NotNull(message = "Last name cannot be null")
    @Size(min = 1, max = 50, message = "Last name must be between 2 and 50 characters")
    private String lastName;

    @Column(name = "designation")
    private String designation;

    @OneToOne
    @JoinColumn(name = "relieving_emp_id", referencedColumnName = "emp_id")
    private Employee relievingEmployee;
    
    @ManyToOne
    @JoinColumn(name = "verified_by_admin_id", referencedColumnName = "emp_id")
    private Employee reladminId;
    
    @OneToOne
    @JoinColumn(name = "rel_joining_id", referencedColumnName = "joining_id")
    private JoiningReport relJoiningId;
    
    @Column(name = "reason")
    private String reason;

    @Column(name = "status")
    private String status;

    @Column(name = "relieving_date")
    private Date relievingDate;
    
 // Constructors
    public RelievingReport() {
    }
    

	public RelievingReport(Long relievingId,
			String firstName,String lastName,String designation, Employee relievingEmployee, Employee reladminId, JoiningReport relJoiningId,
			String reason, String status, Date relievingDate) {
		this.relievingId = relievingId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.designation = designation;
		this.relievingEmployee = relievingEmployee;
		this.reladminId = reladminId;
		this.relJoiningId = relJoiningId;
		this.reason = reason;
		this.status = status;
		this.relievingDate = relievingDate;
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

	public Employee getReladminId() {
		return reladminId;
	}

	public void setReladminId(Employee reladminId) {
		this.reladminId = reladminId;
	}

	public JoiningReport getRelJoiningId() {
		return relJoiningId;
	}

	public void setRelJoiningId(JoiningReport relJoiningId) {
		this.relJoiningId = relJoiningId;
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

	public void setRelievingId(Long relievingId) {
		this.relievingId = relievingId;
	}
	
	public Long getRelievingId() {
		return relievingId;
	}

	

}
