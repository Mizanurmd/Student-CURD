package com.mit.curd.dto.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "country", uniqueConstraints = @UniqueConstraint(columnNames = "cCode"))
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long cId;
    @Column(nullable = false, unique = true)
    private String cCode;
    @Column(nullable = false)
    private String country_name;
    @Column(nullable = false)
    private String currency_name;
    @Column(nullable = false)
    private String language;
    @Column(nullable = true)
    private String nationality;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    private List<Student> students = new ArrayList<>();


}
