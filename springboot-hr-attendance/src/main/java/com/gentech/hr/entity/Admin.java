package com.gentech.hr.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_admins")
public class Admin {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Admin_id")
    private Long adminId;
    
    @Column(name = "Admin_name")
    private String adminName;
    
    @Column(name = "Admin_contact")
    private String adminContact;
    
    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
    private List<Attendance> attendances;

    // Default Constructor
    public Admin() {
    }

    // Parameterized Constructor
    public Admin(String adminName, String adminContact) {
        this.adminName = adminName;
        this.adminContact = adminContact;
    }

    // Getters and Setters
    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminContact() {
        return adminContact;
    }

    public void setAdminContact(String adminContact) {
        this.adminContact = adminContact;
    }
}
