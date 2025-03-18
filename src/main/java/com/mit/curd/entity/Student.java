package com.mit.curd.entity;

import com.mit.curd.enums.Gender;
import jakarta.persistence.*;


@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long sId;
    private String name;
    private String father_name;
    private String mother_name;
    private String dob;
    private String phone;
    private String remark;
    private Gender gender;
    private String email;

    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "cId", nullable = true)
    private Country country;

    public Student() {
    }

    public Student(long sId, String name, String father_name, String mother_name, String dob, String phone, String remark, Gender gender, String email, Country country) {
        this.sId = sId;
        this.name = name;
        this.father_name = father_name;
        this.mother_name = mother_name;
        this.dob = dob;
        this.phone = phone;
        this.remark = remark;
        this.gender = gender;
        this.email = email;
        this.country = country;
    }

    public long getsId() {
        return sId;
    }

    public void setsId(long sId) {
        this.sId = sId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFather_name() {
        return father_name;
    }

    public void setFather_name(String father_name) {
        this.father_name = father_name;
    }

    public String getMother_name() {
        return mother_name;
    }

    public void setMother_name(String mother_name) {
        this.mother_name = mother_name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sId=" + sId +
                ", name='" + name + '\'' +
                ", father_name='" + father_name + '\'' +
                ", mother_name='" + mother_name + '\'' +
                ", dob='" + dob + '\'' +
                ", phone='" + phone + '\'' +
                ", remark='" + remark + '\'' +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                ", country=" + country +
                '}';
    }
}
