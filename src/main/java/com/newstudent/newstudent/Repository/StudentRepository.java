package com.newstudent.newstudent.Repository;

import com.newstudent.newstudent.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    
    //@Query("SELECT first_name FROM Student WHERE class_id=class1")
    //select * from demo.student where class_id=10;

    //get students by class rest api
    List<Student> findAllByClassObjClassId(int classId);

    //@Query("SELECT s FROM Student s WHERE assignedSubjects= assignedSubjects")
    List<Student> findAllByAssignedSubjectsSubName(String subName);
    List<Student> findAllByFirstName(String firstName);

    List<Student> findAllByAssignedSubjectsSubNameAndClassObjClassId(String subName, int classId);

    List<Student> findAllByBirthDateBetween(LocalDate birthDate1, LocalDate birthDate2);

    List<Student> findAllByAssignedSubjectsSubIdIn(List subId);


    //@Query(nativeQuery = true, value="SELECT std_id,roll_no,age,address,first_name,last_name,email,birth_date,class_id,div_id FROM Student WHERE birth_date between :startDate and :endDate")
    //List<Student> findAllByBirthDateBetween(LocalDate date, LocalDate date2);


    //?from={start-date-time}&to={end-date-time}
}

