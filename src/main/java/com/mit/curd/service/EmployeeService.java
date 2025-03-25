package com.mit.curd.service;

import com.mit.curd.dto.EmployeeDTO;
import com.mit.curd.entity.Employee;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    public Optional<EmployeeDTO> getEmployeeById(int id);

    public List<EmployeeDTO> getAllEmployees();

    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO, MultipartFile photo) throws IOException;

    public EmployeeDTO updateEmployee(int id, EmployeeDTO employeeDTO, MultipartFile photo) throws IOException;

    public void deleteEmployee(int id);
}
