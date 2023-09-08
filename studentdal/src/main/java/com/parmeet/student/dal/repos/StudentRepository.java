package com.parmeet.student.dal.repos;

import com.parmeet.student.dal.entities.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {

}
