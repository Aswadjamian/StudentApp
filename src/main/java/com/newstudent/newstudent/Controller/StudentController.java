package com.newstudent.newstudent.Controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.newstudent.newstudent.Model.Class;
import com.newstudent.newstudent.Model.Student;
import com.newstudent.newstudent.Repository.StudentRepository;
import com.newstudent.newstudent.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;
    private StudentRepository studentRepository;

    @PostMapping("/addStudent")
    public String saveStudent(@RequestBody Student student)
    {
        studentService.saveStudent(student);
        return "added successfully";
    }


    @GetMapping("/getStudents")
    public ResponseEntity<List<Student>> getStudents()
    {
        return new ResponseEntity<>(studentService.getStudents(), HttpStatus.OK);
    }



    @DeleteMapping("/deleteStudent/{stdId}")
    public ResponseEntity deleteStudent(@PathVariable int stdId)
    {
        studentService.deleteStudent(stdId);
        return new ResponseEntity(HttpStatus.OK);
    }


    /*@PutMapping("/updateStudent/{std_id}")
    public ResponseEntity<Student> updateStudent(@PathVariable("std_id") Integer std_id, @RequestBody Student student)
    {
        Optional<Student> studentdata = studentService.findByStdId(std_id);
        if(studentdata.isPresent())
        {
            Student student1 = studentdata.get();
            student1.setStdId(student1.getStdId());
            student1.setRollNo(student1.getRollNo());
            student1.setFirstName(student1.getFirstName());
            student1.setLastName(student1.getLastName());
            student1.setAddress(student1.getAddress());
            student1.setEmail(student1.getEmail());
            student1.setAge(student1.getAge());
            student1.setBirthDate(student1.getBirthDate());

            return new ResponseEntity<>(studentService.save(student1), HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }*/

    @PutMapping("/{stdId}/Subject/{subId}")
    public Student assignSubjectsToStudent(@PathVariable int stdId, @PathVariable int subId)
    {
        return studentService.assignSubjectsToStudent(stdId, subId);
    }


    //get students by class rest api
    @GetMapping("/getStudentsByClass/{classId}")
    public List<Student> getAllStudentByClass(@PathVariable int classId)
    {
        return studentService.getAllStudentByClass(classId);
    }

    //get students by subject
    @GetMapping("/getStudentsBySubject/{subName}")
    public List<Student> getStudentsBySubject(@PathVariable String subName)
    {
        return studentService.getStudentsBySubject(subName);
    }

    //get students by subject and class
    @GetMapping("/getStudentsBySelectedSubjectAndClass/{subName}/{classId}")
    public List<Student> getStudentsBySelectedSubjectAndClass(@PathVariable String subName,@PathVariable int classId)
    {
        return studentService.getStudentsBySelectedSubjectAndClass(subName,classId);
    }

    //get students by firstname
    @GetMapping("/getStudentByFirstName/{firstName}")
    public List<Student> getStudentByFirstName(@PathVariable String firstName)
    {
        return studentService.getStudentByFirstName(firstName);
    }

    @RequestMapping(value = "/getStudentsBySelectedSubject/{subId}",method = RequestMethod.GET)
    public List<Student> getStudentsBySelectedSubject(@PathVariable List<Integer> subId)
    {
        return studentService.getStudentsBySelectedSubject(subId);
    }

    @GetMapping("/getStudentsBornInYear/{birthDate1}/{birthDate2}")
    public List<Student> getStudentsBornInYear(@PathVariable (value = "birthDate1")  @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate birthDate1,
                                               @PathVariable (value = "birthDate2") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate birthDate2)
    {
        return studentService.getAllStudentsBornInYear(birthDate1, birthDate2);
    }

    @GetMapping("/getStudentsBySelectedDateRange/{one_date}/{two_date}")
    public List<Student> getStudentBySelectedDateRange(@PathVariable (value = "one_date")  @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate fromDate,
                                    @PathVariable (value = "two_date")  @DateTimeFormat(pattern = "dd-MM-yyyy")  LocalDate toDate)
    {
        return studentService.getStudent(fromDate, toDate);
    }


    /*@GetMapping("/getStudentsBornInYear/{birthDate}")
    public List<Student> getStudentsBornInYear(@PathVariable(value = "birthDate") @JsonFormat(pattern="yyyy") Date birthDate)
    {
        return studentService.getAllStudentsBornInYear(birthDate);
    }*/

}
