package com.mit.curd.serviceImp;

import com.mit.curd.customExeption.CountryNotFoundException;
import com.mit.curd.customExeption.StudentNotFoundException;
import com.mit.curd.dto.StudentDTO;
import com.mit.curd.entity.Country;
import com.mit.curd.entity.Student;
import com.mit.curd.repository.CountryRepository;
import com.mit.curd.repository.StudentRepository;
import com.mit.curd.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final CountryRepository countryRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository, CountryRepository countryRepository) {
        this.studentRepository = studentRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public StudentDTO createStudent(StudentDTO studentDTO) {
        Student student = new Student();
        student.setName(studentDTO.getName());
        student.setFather_name(studentDTO.getFather_name());
        student.setMother_name(studentDTO.getMother_name());
        student.setDob(studentDTO.getDob());
        student.setPhone(studentDTO.getPhone());
        student.setRemark(studentDTO.getRemark());
        student.setGender(studentDTO.getGender());
        student.setEmail(studentDTO.getEmail());

        // Set Country if provided in DTO
        if (studentDTO.getCountryId() != 0) {
            Country country = countryRepository.findById(studentDTO.getCountryId())
                    .orElseThrow(() -> new RuntimeException("Country not found"));
            student.setCountry(country);
        }

        // Save to repository
        Student savedStudent = studentRepository.save(student);
        studentDTO.setsId(savedStudent.getsId());

        return studentDTO;
    }

    @Override
    public StudentDTO updateStudent(long sId, StudentDTO studentDTO) {
        Student exitingStudent = studentRepository.findById(sId)
                .orElseThrow(() -> new StudentNotFoundException("Student with ID : " + sId + " is not found."));

        exitingStudent.setName(studentDTO.getName());
        exitingStudent.setFather_name(studentDTO.getFather_name());
        exitingStudent.setMother_name(studentDTO.getMother_name());
        exitingStudent.setDob(studentDTO.getDob());
        exitingStudent.setPhone(studentDTO.getPhone());
        exitingStudent.setRemark(studentDTO.getRemark());
        exitingStudent.setGender(studentDTO.getGender());
        exitingStudent.setEmail(studentDTO.getEmail());
        if (studentDTO.getCountryId() != 0) {
            Country country = countryRepository.findById(studentDTO.getCountryId())
                    .orElseThrow(() -> new CountryNotFoundException("Country with Id : " + studentDTO.getCountryId() + " is not found"));
            exitingStudent.setCountry(country);
        }
        exitingStudent = studentRepository.save(exitingStudent);
        studentDTO.setsId(exitingStudent.getsId());
        return studentDTO;
    }

    @Override
    public Optional<StudentDTO> getStudentById(long sId) {
        Optional<Student> st = studentRepository.findById(sId);
        return st.map(this::convertToDTO);
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        return studentRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public String deleteStudent(long sId) {
        Student student = studentRepository.findById(sId).orElseThrow(() -> new StudentNotFoundException("Student with ID : " + sId + " is not found"));
        studentRepository.delete(student);
        return "Student with ID :" + sId + " has been successfully deleted.";
    }

    private StudentDTO convertToDTO(Student student) {
        StudentDTO dto = new StudentDTO();
        dto.setsId(student.getsId());
        dto.setName(student.getName());
        dto.setFather_name(student.getFather_name());
        dto.setMother_name(student.getMother_name());
        dto.setDob(student.getDob());
        dto.setPhone(student.getPhone());
        dto.setRemark(student.getRemark());
        dto.setGender(student.getGender());
        dto.setEmail(student.getEmail());

        if (student.getCountry() != null) {
            dto.setCountryId(student.getCountry().getcId());
        }
        return dto;
    }

}
