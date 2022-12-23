package com.newstudent.newstudent.Service;

import com.newstudent.newstudent.Model.Student;
import com.newstudent.newstudent.Model.Subject;
import com.newstudent.newstudent.Repository.StudentRepository;
import com.newstudent.newstudent.Repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class SubjectService {
    @Autowired
    SubjectRepository subjectRepository;
    StudentRepository studentRepository;
    public void saveSubject(Subject subject) {
        subjectRepository.save(subject);
    }

    public List<Subject> getSubjects() {
        return subjectRepository.findAll();
    }

    public void deleteSubject(int subId) {
        subjectRepository.deleteById(subId);
    }

    /*public List<Student> getAllStudents(int subId) {
        return subjectRepository.findAllBySubId(subId);
    }*/


}




