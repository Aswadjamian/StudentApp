package com.newstudent.newstudent.Repository;

import com.newstudent.newstudent.Model.Class;
import com.newstudent.newstudent.Model.Division;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DivisionRepository extends JpaRepository<Division, Integer> {


    List<Division> findAllByClassesClassId(int classId);
}
