package com.newstudent.newstudent.Service;

import com.newstudent.newstudent.Model.Class;
import com.newstudent.newstudent.Model.Division;
import com.newstudent.newstudent.Repository.ClassRepository;
import com.newstudent.newstudent.Repository.DivisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ClassService {
    @Autowired
    private ClassRepository classRepository;
    private DivisionRepository divisionRepository;

    public void saveClass(Class obj) {
        classRepository.save(obj);
    }

    public List<Class> getAllClasses() {
       return classRepository.findAll();
    }

    public void deleteClass(int classId) {
        classRepository.deleteById(classId);
    }

    public Class assignDivisionsToClass(int classId, int divId) {
        List<Division> divisions = null;
        Class cls = classRepository.findById(classId).get();
        Division division = divisionRepository.findById(divId).get();
        divisions = cls.getDivisions();
        divisions.add(division);
        cls.setDivisions(divisions);
        return classRepository.save(cls);
    }


    /*public List<Class> getAllDivisions(int classId) {
        return classRepository.findAllByDivisionsClassId(classId);
    }*/
}
