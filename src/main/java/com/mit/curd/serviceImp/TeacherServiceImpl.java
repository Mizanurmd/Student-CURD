package com.mit.curd.serviceImp;

import com.mit.curd.customExeption.NotFoundId;
import com.mit.curd.dto.TeacherDTO;
import com.mit.curd.dto.entity.Teacher;
import com.mit.curd.repository.TeacherRepository;
import com.mit.curd.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOError;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;

    @Autowired
    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public TeacherDTO createTeacher(TeacherDTO teacherDTO, MultipartFile photo, MultipartFile attachment) throws IOException {
        Teacher t = new Teacher();
        t.setName(teacherDTO.getName());
        t.setFatherName(teacherDTO.getFatherName());
        t.setMotherName(teacherDTO.getMotherName());
        t.setMobile(teacherDTO.getMobile());
        t.setQualification(teacherDTO.getQualification());
        t.setSubject(teacherDTO.getSubject());
        t.setGender(teacherDTO.getGender());
        t.setDepartment(teacherDTO.getDepartment());
        t.setNationality(teacherDTO.getNationality());
        t.setSalary((teacherDTO.getSalary()));
        t.setDob(teacherDTO.getDob());
        t.setEndDate(teacherDTO.getJoiningDate());
        t.setJoiningDate(teacherDTO.getJoiningDate());
        t.setRemarks(teacherDTO.getRemarks());
        if (photo != null && !photo.isEmpty()) {
            t.setPhoto(photo.getBytes());
        }
        if (attachment != null && !attachment.isEmpty()) {
            t.setAttachment(attachment.getBytes());
        }
        Teacher saveTeacher = teacherRepository.save(t);
        teacherDTO.settId(saveTeacher.gettId());
        return teacherDTO;
    }

    @Override
    public TeacherDTO updateTeacher(long tId, TeacherDTO teacherDTO, MultipartFile photo, MultipartFile attachment) throws IOError, IOException {
        Optional<Teacher> optionalTeacher = teacherRepository.findById(tId);
        if (optionalTeacher.isPresent()) {
            Teacher t = optionalTeacher.get();
            t.setName(teacherDTO.getName());
            t.setFatherName(teacherDTO.getFatherName());
            t.setMotherName(teacherDTO.getMotherName());
            t.setMobile(teacherDTO.getMobile());
            t.setQualification(teacherDTO.getQualification());
            t.setSubject(teacherDTO.getSubject());
            t.setGender(teacherDTO.getGender());
            t.setDepartment(teacherDTO.getDepartment());
            t.setNationality(teacherDTO.getNationality());
            t.setSalary(teacherDTO.getSalary());
            t.setDob(teacherDTO.getDob());
            t.setJoiningDate(teacherDTO.getJoiningDate());
            t.setEndDate(teacherDTO.getEndDate());
            t.setRemarks(teacherDTO.getRemarks());

            if (photo != null && !photo.isEmpty()) {
                t.setPhoto(photo.getBytes());
            }
            if (attachment != null && !attachment.isEmpty()) {
                t.setAttachment(attachment.getBytes());
            }

            Teacher updatedTeacher = teacherRepository.save(t);
            teacherDTO.settId(updatedTeacher.gettId());
            return teacherDTO;
        } else {
            throw new NotFoundId("Teacher not found with ID: " + tId);
        }
    }


    @Override
    public List<TeacherDTO> getAllTeachers() {
        return teacherRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<TeacherDTO> getTeacherById(long tId) {
        Optional<Teacher> t = teacherRepository.findById(tId);
        return t.map(this::convertToDTO);
    }

    @Override
    public String deleteTeacher(long tId) {
        Teacher t = teacherRepository.findById(tId).orElseThrow(() -> new NotFoundId("Teacher with Id: " + tId + " is not found"));
        teacherRepository.delete(t);
        return "Teacher with ID :" + tId + " has been successfully deleted.";
    }

    private TeacherDTO convertToDTO(Teacher teacher) {
        TeacherDTO teacherDTO = new TeacherDTO();
        teacherDTO.settId(teacher.gettId());
        teacherDTO.setName(teacher.getName());
        teacherDTO.setFatherName(teacher.getFatherName());
        teacherDTO.setMotherName(teacher.getMotherName());
        teacherDTO.setMobile(teacher.getMobile());
        teacherDTO.setQualification(teacher.getQualification());
        teacherDTO.setSubject(teacher.getSubject());
        teacherDTO.setGender(teacher.getGender());
        teacherDTO.setDepartment(teacher.getDepartment());
        teacherDTO.setNationality(teacher.getNationality());
        teacherDTO.setSalary((teacher.getSalary()));
        teacherDTO.setDob(teacher.getDob());
        teacherDTO.setJoiningDate(teacher.getJoiningDate());
        teacherDTO.setEndDate(teacher.getEndDate());
        teacherDTO.setRemarks(teacher.getRemarks());


        return teacherDTO;
    }

}
