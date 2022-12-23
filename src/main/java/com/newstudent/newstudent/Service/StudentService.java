package com.newstudent.newstudent.Service;

import com.newstudent.newstudent.Model.Student;
import com.newstudent.newstudent.Model.Subject;
import com.newstudent.newstudent.Repository.StudentRepository;
import com.newstudent.newstudent.Repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    SubjectRepository subjectRepository;
    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();

    }

    public void deleteStudent(int stdId) {
        studentRepository.deleteById(stdId);
    }

    public Student assignSubjectsToStudent(int stdId, int subId) {
        List<Subject> subjects = null;
        Student student = studentRepository.findById(stdId).get();
        Subject subject = subjectRepository.findById(subId).get();
        subjects = student.getAssignedSubjects();
        subjects.add(subject);
        student.setAssignedSubjects(subjects);
        return studentRepository.save(student);
    }

    public List<Student> getStudentsBySubject(String subName) {
        return studentRepository.findAllByAssignedSubjectsSubName(subName);
    }


    //get students by class rest api
    public List<Student> getAllStudentByClass(int classId) {
        return studentRepository.findAllByClassObjClassId(classId);
    }

    public List<Student> getStudentByFirstName(String firstName) {
        return studentRepository.findAllByFirstName(firstName);
    }

    public List<Student> getStudentsBySelectedSubjectAndClass(String subName, int classId) {
        return studentRepository.findAllByAssignedSubjectsSubNameAndClassObjClassId(subName,classId);
    }

    public List<Student> getAllStudentsBornInYear(LocalDate birthDate1, LocalDate birthDate2) {
        return studentRepository.findAllByBirthDateBetween(birthDate1, birthDate2);
    }

    public List<Student> getStudent(LocalDate fromDate, LocalDate toDate) {
        return studentRepository.findAllByBirthDateBetween(fromDate,toDate);
    }


    public List<Student> getStudentsBySelectedSubject(List subId) {
        return studentRepository.findAllByAssignedSubjectsSubIdIn(subId);
    }


    /*public List<Student> getAllStudentsBornInYear(Date birthDate) {
        return studentRepository.findAllByBirthDate(birthDate);
    }*/
}
