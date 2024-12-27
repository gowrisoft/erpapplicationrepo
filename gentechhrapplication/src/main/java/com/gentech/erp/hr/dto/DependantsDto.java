package com.gentech.erp.hr.dto;

public class DependantsDto {
    private Long dependantId;
    private String dependantName;
    private Integer dependantAge;

    public DependantsDto() {

    }

    public DependantsDto(Long dependantId, String dependantName, Integer dependantAge) {
        this.dependantId = dependantId;
        this.dependantName = dependantName;
        this.dependantAge = dependantAge;
    }

    public Long getDependantId() {
        return dependantId;
    }

    public void setDependantId(Long dependantId) {
        this.dependantId = dependantId;
    }

    public String getDependantName() {
        return dependantName;
    }

    public void setDependantName(String dependantName) {
        this.dependantName = dependantName;
    }

    public Integer getDependantAge() {
        return dependantAge;
    }

    public void setDependantAge(Integer dependantAge) {
        this.dependantAge = dependantAge;
    }
}
