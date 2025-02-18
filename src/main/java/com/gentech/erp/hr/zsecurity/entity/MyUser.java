package com.gentech.erp.hr.zsecurity.entity;
import com.gentech.erp.hr.entity.Employee;
import jakarta.persistence.*;

@Entity
public class MyUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @Column(unique = true)
    private String username;
    private String password;
    private String role;

    @OneToOne
    @JoinColumn(nullable = false)
    private Employee employee;

    @Column(nullable = false)
    private boolean isVerified = false;

    public MyUser() {
    }

    public MyUser(Long userId, String username, String password, String role, Employee employee, boolean isVerified) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.role = role;
        this.employee = employee;
        this.isVerified = isVerified;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public void setVerified(boolean verified) {
        isVerified = verified;
    }
}