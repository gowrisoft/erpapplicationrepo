package com.gentech.erp.hr.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "admin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admin_id")
    private int adminId;
    @Column(name = "admin_name")
    private String adminName;
    @Column(name = "admin_phone")
    private long adminPhone;
    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SanctionLeave> sanctionLeaves;

    public Admin() {

    }

    public Admin(int adminId, String adminName, long adminPhone, List<SanctionLeave> sanctionLeaves) {
        super();
        this.adminId = adminId;
        this.adminName = adminName;
        this.adminPhone = adminPhone;
        this.sanctionLeaves = sanctionLeaves;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public long getAdminPhone() {
        return adminPhone;
    }

    public void setAdminPhone(long adminPhone) {
        this.adminPhone = adminPhone;
    }

    public List<SanctionLeave> getSanctionLeaves() {
        return sanctionLeaves;
    }

    public void setSanctionLeaves(List<SanctionLeave> sanctionLeaves) {
        this.sanctionLeaves = sanctionLeaves;
    }
}