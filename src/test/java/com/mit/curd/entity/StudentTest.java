package com.mit.curd.entity;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class StudentTest {
private Student student;
    @BeforeEach
    void setUp() {
        student = new Student();
        student.setsId(1);
        student.setName("Mizanur");
        student.setFather_name("Father");
        student.setMother_name("Mother");
        System.out.println(student);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getsId() {
        assertEquals(student.getsId(), 1);
    }

    @Test
    void setsId() {
    }
}