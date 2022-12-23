package com.newstudent.newstudent.Repository;

import com.newstudent.newstudent.Model.Student;
import com.newstudent.newstudent.Model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SubjectRepository extends JpaRepository<Subject, Integer> {
    //@Query("select rollNo,firstName,lastName,address,email,age,birthDate from Student s ")

    //List<Student> findAllBySubId(int subId);
}
