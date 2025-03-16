package com.mit.curd.controller;

import com.mit.curd.customExeption.NotFoundId;
import com.mit.curd.dto.TeacherDTO;
import com.mit.curd.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/v1/teachers")
public class TeacherController {
    private final TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @PostMapping(value = "/save", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<TeacherDTO> saveTeacher(
            @RequestPart("teacher") @Validated @ModelAttribute TeacherDTO teacherDTO,
            @RequestPart(value = "photo", required = false) MultipartFile photo,
            @RequestPart(value = "attachment", required = false) MultipartFile attachment) throws IOException {

        TeacherDTO createdTeacher = teacherService.createTeacher(teacherDTO, photo, attachment);
        return new ResponseEntity<>(createdTeacher, HttpStatus.CREATED);
    }

    @PutMapping(value = "/update/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<TeacherDTO> updateTeacher(
            @PathVariable("id") long tId,
            @RequestPart("teacher") @Validated @ModelAttribute TeacherDTO teacherDTO,
            @RequestPart(value = "photo", required = false) MultipartFile photo,
            @RequestPart(value = "attachment", required = false) MultipartFile attachment) throws IOException {

        TeacherDTO updateTeacher = teacherService.updateTeacher(tId, teacherDTO, photo, attachment);
        return new ResponseEntity<>(updateTeacher, HttpStatus.OK);
    }


    @GetMapping("/all")
    public ResponseEntity<List<TeacherDTO>> getAll() {
        List<TeacherDTO> teacherList = teacherService.getAllTeachers();
        return new ResponseEntity<>(teacherList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeacherDTO> getTeacherId(@PathVariable("id") long tId) {
        return teacherService.getTeacherById(tId).map(ResponseEntity::ok)
                .orElseThrow(() -> new NotFoundId("Teacher with Id : " + tId + " is not found."));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> getDeleteTeacherId(@PathVariable("id") long tId) {
        String deletedId = teacherService.deleteTeacher(tId);
        return new ResponseEntity<>(deletedId, HttpStatus.OK);
    }
}
