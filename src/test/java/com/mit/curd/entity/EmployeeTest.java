package com.mit.curd.entity;

import com.mit.curd.enums.Department;
import com.mit.curd.enums.Gender;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    private Employee employee;

    @BeforeEach
    void setUp() {
        employee = new Employee();
        employee.setId(1);
        employee.setName("John");
        employee.setSurname("Doe");
        employee.setDesignation("Developer");
        employee.setSalary(50000.0);
        employee.setDepartment(Department.valueOf("IT"));
        employee.setGender(Gender.valueOf("MALE"));
        employee.setEmail("john.doe@example.com");
        employee.setPhone("1234567890");
        employee.setPhoto("profile.jpg".getBytes());

        Address address = new Address();
        address.setCity("Bangalore");
        address.setStreet("MG Road");
        address.setZip("560001");
        employee.setAddress(address);
        System.out.println(employee);
    }

    @AfterEach
    void tearDown() {
       System.out.println("After completed test =====================::: "+employee);
    }

    @Test
    void getId() {
        assertEquals(1L, employee.getId());
    }

    @Test
    void getName() {
        assertEquals("John", employee.getName());
    }

    @Test
    void getSurname() {
        assertEquals("Doe", employee.getSurname());
    }

    @Test
    void getDesignation() {
        assertEquals("Developer", employee.getDesignation());
    }

    @Test
    void getSalary() {
        assertEquals(50000.0, employee.getSalary());
    }

    @Test
    void getDepartment() {
        assertEquals(Department.IT, employee.getDepartment());
    }

    @Test
    void getGender() {
        assertEquals(Gender.MALE, employee.getGender());
    }

    @Test
    void getEmail() {
        assertEquals("john.doe@example.com", employee.getEmail());
    }

    @Test
    void getPhone() {
        assertEquals("1234567890", employee.getPhone());
    }

    @Test
    void getPhoto() {
        byte[] expectedPhoto = "profile.jpg".getBytes();
        employee.setPhoto(expectedPhoto);
        assertArrayEquals(expectedPhoto, employee.getPhoto());
    }

    @Test
    void getAddress() {
        assertEquals("Bangalore", employee.getAddress().getCity());
    }

    @Test
    void setId() {
        employee.setId(2);
        assertEquals(2L, employee.getId());
    }

    @Test
    void setName() {
        employee.setName("Alice");
        assertEquals("Alice", employee.getName());
    }

    @Test
    void setSurname() {
        employee.setSurname("Smith");
        assertEquals("Smith", employee.getSurname());
    }

    @Test
    void setDesignation() {
        employee.setDesignation("Manager");
        assertEquals("Manager", employee.getDesignation());
    }

    @Test
    void setSalary() {
        employee.setSalary(60000.0);
        assertEquals(60000.0, employee.getSalary());
    }

    @Test
    void setDepartment() {
        employee.setDepartment(Department.valueOf("ACCOUNTING"));
        assertEquals(Department.ACCOUNTING, employee.getDepartment());
    }

    @Test
    void setGender() {
        employee.setGender(Gender.valueOf("FEMALE"));
        assertEquals(Gender.FEMALE, employee.getGender());
    }

    @Test
    void setEmail() {
        employee.setEmail("alice.smith@example.com");
        assertEquals("alice.smith@example.com", employee.getEmail());
    }

    @Test
    void setPhone() {
        employee.setPhone("9876543210");
        assertEquals("9876543210", employee.getPhone());
    }

    @Test
    void setPhoto() {
        byte[] expectedPhoto = "alice.jpg".getBytes();
        employee.setPhoto(expectedPhoto);
        assertArrayEquals(expectedPhoto, employee.getPhoto());
    }

    @Test
    void setAddress() {
        Address address = new Address();
        address.setCity("Park Avenue");
        address.setStreet("MG Road");
        address.setZip("560001");

        employee.setAddress(address);
        assertEquals("Park Avenue", employee.getAddress().getCity());
    }

    @Test
    void testEquals() {
        Employee another = new Employee();
        another.setId(1);
        another.setName("John");
        another.setSurname("Doe");
        another.setDesignation("Developer");
        another.setSalary(50000.0);
        another.setDepartment(Department.valueOf("IT"));
        another.setGender(Gender.valueOf("MALE"));
        another.setEmail("john.doe@example.com");
        another.setPhone("1234567890");
        another.setPhoto("profile.jpg".getBytes());

        Address address = new Address();
        address.setCity("Bangalore");
        address.setStreet("MG Road");
        address.setZip("560001");
        another.setAddress(address);

        assertEquals(employee, another);
    }

    @Test
    void canEqual() {
        Employee another = new Employee();
        assertTrue(employee.canEqual(another));
    }

    @Test
    void testHashCode() {
        Employee another = new Employee();
        another.setId(1);
        another.setName("John");
        another.setSurname("Doe");
        another.setDesignation("Developer");
        another.setSalary(50000.0);
        another.setDepartment(Department.valueOf("IT"));
        another.setGender(Gender.valueOf("MALE"));
        another.setEmail("john.doe@example.com");
        another.setPhone("1234567890");
        another.setPhoto("profile.jpg".getBytes());

        Address address = new Address();
        address.setCity("Bangalore");
        address.setStreet("MG Road");
        address.setZip("560001");
        another.setAddress(address);

        assertEquals(employee.hashCode(), another.hashCode());
    }

    @Test
    void testToString() {
        String str = employee.toString();
        assertTrue(str.contains("Employee"));
        assertTrue(str.contains("John"));
        assertTrue(str.contains("Doe"));
        assertTrue(str.contains("IT")); // Enum value
        assertTrue(str.contains("john.doe@example.com"));
    }
}
