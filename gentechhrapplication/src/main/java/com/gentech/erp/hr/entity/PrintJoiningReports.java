package com.gentech.erp.hr.entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "tbl_print_joining_report")
public class PrintJoiningReports {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "print_id")
    private Long printId;

    @Column(name = "print_date")
    private Date printDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "print_joining_id", referencedColumnName = "joining_id")
    private JoiningReport printJoiningId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "print_admin_id", referencedColumnName = "admin_id")
    private Admin printadminId;

    @Column(name = "status")
    private String status;

    public PrintJoiningReports() {

    }

    public PrintJoiningReports(Date printDate, JoiningReport printJoiningId, Admin printadminId, String status) {
        super();
        this.printDate = printDate;
        this.printJoiningId = printJoiningId;
        this.printadminId = printadminId;
        this.status = status;
    }

    public PrintJoiningReports(Long printId, Date printDate, JoiningReport printJoiningId, Admin printadminId, String status) {
        this.printId = printId;
        this.printDate = printDate;
        this.printJoiningId = printJoiningId;
        this.printadminId = printadminId;
        this.status = status;
    }

    public Long getPrintId() {
        return printId;
    }

    public void setPrintId(Long printId) {
        this.printId = printId;
    }

    public Date getPrintDate() {
        return printDate;
    }

    public void setPrintDate(Date printDate) {
        this.printDate = printDate;
    }

    public JoiningReport getPrintJoiningId() {
        return printJoiningId;
    }

    public void setPrintJoiningId(JoiningReport printJoiningId) {
        this.printJoiningId = printJoiningId;
    }

    public Admin getPrintadminId() {
        return printadminId;
    }

    public void setPrintadminId(Admin printadminId) {
        this.printadminId = printadminId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
