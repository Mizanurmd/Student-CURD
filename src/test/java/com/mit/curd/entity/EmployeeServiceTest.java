package com.mit.curd.entity;

import com.mit.curd.customExeption.NotFoundId;
import com.mit.curd.dto.AddressDTO;
import com.mit.curd.dto.EmployeeDTO;
import com.mit.curd.enums.Department;
import com.mit.curd.enums.Gender;
import com.mit.curd.repository.EmployeeRepository;
import com.mit.curd.serviceImp.EmployeeServiceImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.mock.web.MockMultipartFile;

import java.io.IOException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


class EmployeeServiceImpTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeServiceImp employeeServiceImp;

    private Employee employee;
    private EmployeeDTO employeeDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        employee = new Employee();
        employee.setId(1);
        employee.setName("Alice");
        employee.setSurname("Smith");
        employee.setDesignation("Developer");
        employee.setSalary(60000.0);
        employee.setEmail("alice@example.com");
        employee.setPhone("9876543210");
        employee.setDepartment(Department.IT);
        employee.setGender(Gender.FEMALE);
        employee.setPhoto("photo-data".getBytes());
        Address address = new Address();
        address.setStreet("Street 1");
        address.setCity("City 1");
        address.setState("State 1");
        address.setZip("12345");
        address.setCountry("Country 1");
        employee.setAddress(address);

        employeeDTO = new EmployeeDTO();
        employeeDTO.setName("Alice");
        employeeDTO.setSurname("Smith");
        employeeDTO.setDesignation("Developer");
        employeeDTO.setSalary(60000.0);
        employeeDTO.setEmail("alice@example.com");
        employeeDTO.setPhone("9876543210");
        employeeDTO.setDepartment(Department.IT);
        employeeDTO.setGender(Gender.FEMALE);
        employeeDTO.setPhotoBase64("photo-data");
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setStreet("Street 1");
        addressDTO.setCity("City 1");
        addressDTO.setState("State 1");
        addressDTO.setZip("12345");
        addressDTO.setCountry("Country 1");
        employeeDTO.setAddress(addressDTO);
        System.out.println(employeeDTO);
    }

    @Test
    void testGetEmployeeById_Success() {
        when(employeeRepository.findById(1)).thenReturn(Optional.of(employee));

        Optional<EmployeeDTO> result = employeeServiceImp.getEmployeeById(1);

        assertTrue(result.isPresent());
        assertEquals("Alice", result.get().getName());
        verify(employeeRepository, times(1)).findById(1);
    }

    @Test
    void testGetAllEmployees_ReturnsList() {
        List<Employee> employees = Collections.singletonList(employee);
        when(employeeRepository.findAll()).thenReturn(employees);

        List<EmployeeDTO> result = employeeServiceImp.getAllEmployees();

        assertEquals(1, result.size());
        assertEquals("Alice", result.get(0).getName());
    }

    @Test
    void testCreateEmployee_Success() throws IOException {
        MockMultipartFile photo = new MockMultipartFile("file", "photo.jpg", "image/jpeg", "test image".getBytes());

        when(employeeRepository.save(any(Employee.class))).thenAnswer(invocation -> {
            Employee emp = invocation.getArgument(0);
            emp.setId(1);
            return emp;
        });

        EmployeeDTO result = employeeServiceImp.createEmployee(employeeDTO, photo);

        assertNotNull(result);
        assertEquals("Alice", result.getName());
        verify(employeeRepository, times(1)).save(any(Employee.class));
    }

    @Test
    void testUpdateEmployee_Success() throws IOException {
        when(employeeRepository.findById(1)).thenReturn(Optional.of(employee));
        when(employeeRepository.save(any(Employee.class))).thenReturn(employee);

        MockMultipartFile photo = new MockMultipartFile("file", "photo.jpg", "image/jpeg", "updated image".getBytes());

        EmployeeDTO result = employeeServiceImp.updateEmployee(1, employeeDTO, photo);

        assertNotNull(result);
        assertEquals("Alice", result.getName());
        verify(employeeRepository, times(1)).save(any(Employee.class));
    }

    @Test
    void testUpdateEmployee_NotFound() {
        when(employeeRepository.findById(99)).thenReturn(Optional.empty());

        Exception exception = assertThrows(NotFoundId.class, () -> {
            employeeServiceImp.updateEmployee(99, employeeDTO, null);
        });

        assertEquals("Teacher not found with ID: 99", exception.getMessage());
    }

    @Test
    void testDeleteEmployee() {
        doNothing().when(employeeRepository).deleteById(1);

        employeeServiceImp.deleteEmployee(1);

        verify(employeeRepository, times(1)).deleteById(1);
    }
}

