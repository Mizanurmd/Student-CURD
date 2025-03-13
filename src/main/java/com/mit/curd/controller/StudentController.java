package com.mit.curd.controller;

import com.mit.curd.customExeption.StudentNotFoundException;
import com.mit.curd.dto.StudentDTO;
import com.mit.curd.entity.Student;
import com.mit.curd.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/save")
    public ResponseEntity<StudentDTO> saveStudent(@RequestBody StudentDTO studentDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createStudent(studentDTO));
    }


//
//    @PutMapping("/update/{id}")
//    public ResponseEntity<Student> updateStudent(@PathVariable("id") long sId, @RequestBody StudentDTO studentDTO) {
//        Student updatedStud = studentService.updateStudent(sId, studentDTO);
//        return new ResponseEntity<>(updatedStud, HttpStatus.OK);
//    }

    @GetMapping("/all")
    public ResponseEntity<List<StudentDTO>> getAllStudents() {
        List<StudentDTO> studentList = studentService.getAllStudents();
        return new ResponseEntity<>(studentList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable("id") long sId) {
        return studentService.getStudentById(sId).map(ResponseEntity::ok)
                .orElseThrow(() -> new StudentNotFoundException("Student with Id : " + sId + " is not found."));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudentById(@PathVariable("id") long sId) {
        String message = studentService.deleteStudent(sId);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

}
