package com.example.student.studentInfo.repository;

import com.example.student.studentInfo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
  List<Student> findAllBySchoolId(Integer schoolId);

}
