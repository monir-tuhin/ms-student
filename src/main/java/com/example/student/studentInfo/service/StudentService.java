package com.example.student.studentInfo.service;

import com.example.student.studentInfo.entity.Student;
import com.example.student.studentInfo.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

  private final StudentRepository studentRepository;

  public void saveStudent(Student student) {
    studentRepository.save(student);
  }

  public List<Student> findAllStudents() {
    return studentRepository.findAll();
  }

  public List<Student> findAllStudentsBySchool(Integer schoolId) {
    return studentRepository.findAllBySchoolId(schoolId);
  }


}
