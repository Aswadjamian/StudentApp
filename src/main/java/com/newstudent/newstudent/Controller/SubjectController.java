package com.newstudent.newstudent.Controller;

import com.newstudent.newstudent.Model.Class;
import com.newstudent.newstudent.Model.Student;
import com.newstudent.newstudent.Model.Subject;
import com.newstudent.newstudent.Repository.StudentRepository;
import com.newstudent.newstudent.Service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    @PostMapping("/addSubject")
    public ResponseEntity<Subject> saveSubject(@RequestBody Subject subject)
    {
        subjectService.saveSubject(subject);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/getSubjects")
    public ResponseEntity<List<Subject>> getSubjects()
    {
        return new ResponseEntity<>(subjectService.getSubjects(), HttpStatus.OK);
    }


    @DeleteMapping("/deleteSubject/{subId}")
    public ResponseEntity deleteSubject(@PathVariable int subId)
    {
        subjectService.deleteSubject(subId);
        return new ResponseEntity(HttpStatus.OK);
    }

    /*@GetMapping("/getStudents/{subId}")
    public List<Student> getStudents(@PathVariable int subId)
    {
        return subjectService.getAllStudents(subId);
    }*/

}
