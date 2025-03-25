package com.mit.curd.dto;

import com.mit.curd.enums.Department;
import com.mit.curd.enums.Gender;
import lombok.Data;

@Data
public class EmployeeDTO {
    private int id;
    private String name;
    private String surname;
    private String designation;
    private double salary;
    private Department department;
    private Gender gender;
    private String email;
    private String phone;
    private String photoBase64;
    private AddressDTO address;
}
