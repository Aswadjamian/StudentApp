package com.newstudent.newstudent.Controller;

import com.newstudent.newstudent.Model.Class;
import com.newstudent.newstudent.Service.ClassService;
import com.newstudent.newstudent.Service.DivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//@RequestMapping("class")
@RestController
public class ClassController {
    @Autowired
    private ClassService classService;
    private DivisionService divisionService;

    @PostMapping("/addClass")
    public ResponseEntity<Class> saveClass(@RequestBody Class obj)
    {
        classService.saveClass(obj);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/getClasses")
    public ResponseEntity<List<Class>> getClasses()
    {
        return new ResponseEntity<>(classService.getAllClasses(), HttpStatus.OK);
    }


    @DeleteMapping("/deleteClass/{classId}")
    public ResponseEntity deleteClass(@PathVariable int classId)
    {
        classService.deleteClass(classId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/{classId}/Division/{divId}")
    public Class assignDivisionsToClass(@PathVariable int classId, @PathVariable int divId)
    {
        return classService.assignDivisionsToClass(classId, divId);
    }

    /*@GetMapping("/getDivisions/{classId}")
    public List<Class> getDivisions(@PathVariable int classId)
    {
        return classService.getAllDivisions(classId);
    }*/


}
