package com.mit.curd.controller;

import com.mit.curd.customExeption.NotFoundId;
import com.mit.curd.dto.EmployeeDTO;

import com.mit.curd.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("api/v1/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> findEmployeeById(@PathVariable("id") int id) {
        return employeeService.getEmployeeById(id).map(ResponseEntity::ok).orElseThrow(() -> new NotFoundId("Employee with id " + id + " not found"));
    }

    @GetMapping("/all")
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
        List<EmployeeDTO> employeeList = employeeService.getAllEmployees();
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<EmployeeDTO> saveEmployee(
            @RequestPart("employee") @Validated @ModelAttribute EmployeeDTO employeeDTO,
            @RequestPart(value = "photo", required = false) MultipartFile photo) throws IOException {
        EmployeeDTO saveEmp = employeeService.createEmployee(employeeDTO, photo);
        return new ResponseEntity<>(saveEmp, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<EmployeeDTO> updateEmployee(
            @PathVariable("id") int id,
            @RequestPart("employee") @Validated @ModelAttribute EmployeeDTO employeeDTO,
            @RequestPart(value = "photo", required = false) MultipartFile photo) throws IOException {
        EmployeeDTO updatedEmp = employeeService.updateEmployee(id, employeeDTO, photo);
        return new ResponseEntity<>(updatedEmp, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable("id") int id) {
        employeeService.deleteEmployee(id);
    }

}
