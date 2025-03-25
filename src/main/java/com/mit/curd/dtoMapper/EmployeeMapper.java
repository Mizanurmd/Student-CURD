package com.mit.curd.dtoMapper;

import com.mit.curd.dto.EmployeeDTO;
import com.mit.curd.entity.Employee;

import java.util.Base64;

public class EmployeeMapper {
    public static EmployeeDTO convertToEmployee(Employee employee) {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setId(employee.getId());
        dto.setName(employee.getName());
        dto.setSurname(employee.getSurname());
        dto.setDesignation(employee.getDesignation());
        dto.setSalary(employee.getSalary());
        dto.setDepartment(employee.getDepartment());
        dto.setGender(employee.getGender());
        dto.setEmail(employee.getEmail());
        dto.setPhone(employee.getPhone());
        //convert photo to base64
        if (employee.getPhoto() != null) {
            dto.setPhotoBase64(Base64.getEncoder().encodeToString(employee.getPhoto()));
        }

        return dto;
    }
}
