package com.mit.curd.service;

import com.mit.curd.dto.TeacherDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOError;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface TeacherService {
    TeacherDTO createTeacher(TeacherDTO teacherDTO, MultipartFile photo, MultipartFile attachment) throws IOException;

    TeacherDTO updateTeacher(long tId, TeacherDTO teacherDTO, MultipartFile photo, MultipartFile attachment) throws IOError, IOException;

    List<TeacherDTO> getAllTeachers();

    Optional<TeacherDTO> getTeacherById(long tId);

    String deleteTeacher(long tId);

}
