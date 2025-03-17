package com.mit.curd.dto.entity;

import com.mit.curd.enums.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="student")
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


}
