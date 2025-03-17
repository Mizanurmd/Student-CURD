package com.mit.curd.dto;

import com.mit.curd.enums.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
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
    private long countryId;

}
