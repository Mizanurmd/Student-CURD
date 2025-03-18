package com.mit.curd.service;

import com.mit.curd.dto.StudentDTO;
import com.mit.curd.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    StudentDTO createStudent(StudentDTO studentDTO);

    StudentDTO updateStudent(long sId, StudentDTO studentDTO);

    Optional<StudentDTO> getStudentById(long sId);

    List<StudentDTO> getAllStudents();

    String deleteStudent(long sId);

    List<Student> searchStudent(String keyword);

}
