package com.mit.curd.entity;

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
@Table(name="address")
public class Address {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String country;
    @OneToOne(mappedBy = "address", cascade=CascadeType.ALL)
    private Employee employee;

}
