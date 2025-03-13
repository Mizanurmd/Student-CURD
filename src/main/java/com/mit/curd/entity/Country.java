package com.mit.curd.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "country")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long cId;
    private String cCode;
    private String country_name;
    private String currency_name;
    private String language;
    private String nationality;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    private List<Student> students = new ArrayList<>();

    public Country() {
    }

    public Country(long cId, String cCode, String country_name, String currency_name, String language, String nationality, List<Student> students) {
        this.cId = cId;
        this.cCode = cCode;
        this.country_name = country_name;
        this.currency_name = currency_name;
        this.language = language;
        this.nationality = nationality;
        this.students = students;
    }

    public long getcId() {
        return cId;
    }

    public void setcId(long cId) {
        this.cId = cId;
    }

    public String getcCode() {
        return cCode;
    }

    public void setcCode(String cCode) {
        this.cCode = cCode;
    }

    public String getCountry_name() {
        return country_name;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }

    public String getCurrency_name() {
        return currency_name;
    }

    public void setCurrency_name(String currency_name) {
        this.currency_name = currency_name;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Country{" +
                "cId=" + cId +
                ", cCode='" + cCode + '\'' +
                ", country_name='" + country_name + '\'' +
                ", currency_name='" + currency_name + '\'' +
                ", language='" + language + '\'' +
                ", nationality='" + nationality + '\'' +
                ", students=" + students +
                '}';
    }
}
