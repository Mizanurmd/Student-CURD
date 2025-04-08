package com.mit.curd.entity;

import com.mit.curd.enums.Gender;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    private Student student;

    @BeforeEach
    void setUp() {
        System.out.println("This is the start of test case.");
        student = new Student();
        student.setsId(1);
        student.setName("Md.Mizanur Rahman");
        student.setFather_name("Father");
        student.setMother_name("Mother");
        student.setDob("10-02-1991");
        student.setPhone("123456789");
        student.setRemark("I am an Assistant Software Programmer of CNSL");
        student.setGender(Gender.valueOf("MALE"));
        student.setEmail("mizanur@gmail.com");
        Country country = new Country();
        country.setcId(1);
        country.setcCode("+880");
        country.setCountry_name("Bangladesh");
        country.setLanguage("Bangla");
        country.setNationality("Bangladeshi");
        country.setCurrency_name("Taka");
        student.setCountry(country);
        System.out.println(student);
    }

    @AfterEach
    void tearDown() {
        System.out.println("This is the end of the test case.");
    }

    @Test
    void getsId() {
        assertEquals(student.getsId(), 1);
    }

    @Test
    void setsId() {
        student.setsId(2);
        assertEquals(student.getsId(), 2);
    }

    @Test
    void getsName() {
        assertEquals(student.getName(), "Md.Mizanur Rahman");
    }

    @Test
    void getEmail(){
        assertEquals(student.getEmail(), "mizanur@gmail.com");
    }

    @Test
    void setEmail() {
        student.setEmail("tanvir@gmail.com");
        assertEquals(student.getEmail(), "tanvir@gmail.com");
    }


}