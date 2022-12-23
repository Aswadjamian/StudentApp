package com.newstudent.newstudent.Service;

import com.newstudent.newstudent.Model.Class;
import com.newstudent.newstudent.Model.Division;
import com.newstudent.newstudent.Model.Student;
import com.newstudent.newstudent.Model.Subject;
import com.newstudent.newstudent.Repository.DivisionRepository;
import com.newstudent.newstudent.Repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DivisionService {
    @Autowired
    DivisionRepository divisionRepository;

    public void saveDivision(Division division) {
        divisionRepository.save(division);
    }

    public List<Division> getDivisions() {
        return divisionRepository.findAll();

    }

    public void deleteDivision(int divId) {
        divisionRepository.deleteById(divId);
    }


    public List<Division> getAllDivisions(int classId) {
        return divisionRepository.findAllByClassesClassId(classId);
    }
}
