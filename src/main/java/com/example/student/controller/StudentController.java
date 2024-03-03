package com.example.student.controller;

import com.example.student.studentInfo.entity.Student;
import com.example.student.studentInfo.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/student")
@RequiredArgsConstructor
public class StudentController {

  private final StudentService studentService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public void save(@RequestBody Student student) {
    try {
      studentService.saveStudent(student);
    } catch (RuntimeException e) {
      e.printStackTrace();
    }
  }

  @GetMapping
  public ResponseEntity<List<Student>> findAllStudents() {
    try {
      return ResponseEntity.ok(studentService.findAllStudents());
    } catch (RuntimeException e) {
      e.printStackTrace();
      return null;
    }
  }

  @GetMapping("/school/{schoolId}")
  public ResponseEntity<List<Student>> findAllStudents(@PathVariable("schoolId") Integer schoolId) {
    try {
      return ResponseEntity.ok(studentService.findAllStudentsBySchool(schoolId));
    } catch (RuntimeException e) {
      e.printStackTrace();
      return null;
    }
  }

  @GetMapping("/test")
  public String getTest() {
   return "Hello spring !";
  }

}
