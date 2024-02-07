package com.codedifferently.studentsystem.service;

import com.codedifferently.studentsystem.model.Student;
import com.codedifferently.studentsystem.repository.StudentRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
         return studentRepository.findAll();
    }
    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(Math.toIntExact(id))
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));
    }

    @Override
    public void updateStudent(Long id, Student updatedStudent) {
        Student existingStudent = studentRepository.findById(Math.toIntExact(id))
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));

        existingStudent.setName(updatedStudent.getName());
        existingStudent.setAddress(updatedStudent.getAddress());

        studentRepository.save(existingStudent);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(Math.toIntExact(id));
    }
}

