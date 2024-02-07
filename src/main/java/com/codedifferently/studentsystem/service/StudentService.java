package com.codedifferently.studentsystem.service;

import com.codedifferently.studentsystem.model.Student;
import org.springframework.stereotype.Service;
import java.util.List;


public interface StudentService {
    public Student saveStudent(Student student);
    public List<Student> getAllStudents();

    Student getStudentById(Long id);

    void updateStudent(Long id, Student updatedStudent);

    void deleteStudent(Long id);
}
