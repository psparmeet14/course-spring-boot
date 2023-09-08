package com.parmeet.student.dal;

import com.parmeet.student.dal.entities.Student;
import com.parmeet.student.dal.repos.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StudentdalApplicationTests {

    @Autowired
    private StudentRepository repo;

    @Test
    void testCreateStudent() {
        Student student = new Student();
        student.setName("John");
        student.setCourse("Core Java");
        student.setFee(30d);
        repo.save(student);
    }

    @Test
    void testFindStudentById() {
        Student student = repo.findById(1L).get();
        System.out.println(student);
    }

    @Test
    void testUpdateStudent() {
        Student student = repo.findById(2L).get();
        student.setFee(50d);
        repo.save(student);
    }

    @Test
    void deleteStudent() {
        Student student = repo.findById(1L).get();
        repo.delete(student);
    }
}
