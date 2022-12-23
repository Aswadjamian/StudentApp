package com.newstudent.newstudent.Repository;

import com.newstudent.newstudent.Model.Class;
import com.newstudent.newstudent.Model.Division;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClassRepository extends JpaRepository<Class, Integer> {


}
