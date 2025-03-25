package com.mit.curd.serviceImp;

import com.mit.curd.customExeption.NotFoundId;
import com.mit.curd.dto.EmployeeDTO;
import com.mit.curd.dtoMapper.EmployeeMapper;
import com.mit.curd.entity.Employee;
import com.mit.curd.repository.EmployeeRepository;
import com.mit.curd.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImp implements EmployeeService {

    private final EmployeeRepository employeeRepository;


    @Autowired
    public EmployeeServiceImp(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;

    }

    @Override
    public Optional<EmployeeDTO> getEmployeeById(int id) {
        Optional<Employee> empId = employeeRepository.findById(id);
        return empId.map(EmployeeMapper::convertToEmployee);
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        return employeeRepository.findAll().stream().map(EmployeeMapper::convertToEmployee).collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO, MultipartFile photo) throws IOException {
        Employee employee = new Employee();
        employee.setName(employeeDTO.getName());
        employee.setSurname(employeeDTO.getSurname());
        employee.setDesignation(employeeDTO.getDesignation());
        employee.setSalary(employeeDTO.getSalary());
        employee.setDepartment(employeeDTO.getDepartment());
        employee.setGender(employeeDTO.getGender());
        employee.setEmail(employeeDTO.getEmail());
        employee.setPhone(employeeDTO.getPhone());
        // save photo if provided
        if (photo != null && !photo.isEmpty()) {
            employee.setPhoto(photo.getBytes());
        }

        Employee savedEmployee = employeeRepository.save(employee);
        employeeDTO.setId(savedEmployee.getId());

        return employeeDTO;
    }

    @Override
    public EmployeeDTO updateEmployee(int id, EmployeeDTO employeeDTO, MultipartFile photo) throws IOException {
        Optional<Employee> employeeId = employeeRepository.findById(id);
        if (employeeId.isPresent()) {
            Employee employee = new Employee();
            employee.setName(employeeDTO.getName());
            employee.setSurname(employeeDTO.getSurname());
            employee.setDesignation(employeeDTO.getDesignation());
            employee.setSalary(employeeDTO.getSalary());
            employee.setDepartment(employeeDTO.getDepartment());
            employee.setGender(employeeDTO.getGender());
            employee.setEmail(employeeDTO.getEmail());
            employee.setPhone(employeeDTO.getPhone());
            // Update photo if provided
            if (photo != null && !photo.isEmpty()) {
                employee.setPhoto(photo.getBytes());
            }

            Employee updateEmployee = employeeRepository.save(employee);
            employeeDTO.setId(updateEmployee.getId());
            return employeeDTO;
        } else {
            throw new NotFoundId("Teacher not found with ID: " + id);
        }

    }

    @Override
    public void deleteEmployee(int id) {
       employeeRepository.deleteById(id);
    }
}
