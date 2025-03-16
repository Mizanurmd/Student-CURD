package com.mit.curd.dto;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;



public class TeacherDTO {

    private Long tId;
    private String name;
    private String fatherName;
    private String motherName;
    private String mobile;
    private String qualification;
    private String subject;
    private String gender;
    private String department;
    private String nationality;
    private Double salary;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dob;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate joiningDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate endDate;
    private String remarks;

    public TeacherDTO() {
    }

    public TeacherDTO(Long tId, String name, String fatherName, String motherName, String mobile, String qualification, String subject, String gender, String department, String nationality, Double salary, LocalDate dob, LocalDate joiningDate, LocalDate endDate, String remarks) {
        this.tId = tId;
        this.name = name;
        this.fatherName = fatherName;
        this.motherName = motherName;
        this.mobile = mobile;
        this.qualification = qualification;
        this.subject = subject;
        this.gender = gender;
        this.department = department;
        this.nationality = nationality;
        this.salary = salary;
        this.dob = dob;
        this.joiningDate = joiningDate;
        this.endDate = endDate;
        this.remarks = remarks;
    }

    public Long gettId() {
        return tId;
    }

    public void settId(Long tId) {
        this.tId = tId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public LocalDate getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(LocalDate joiningDate) {
        this.joiningDate = joiningDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

}
