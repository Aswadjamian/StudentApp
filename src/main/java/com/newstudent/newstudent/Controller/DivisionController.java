package com.newstudent.newstudent.Controller;

import com.newstudent.newstudent.Model.Class;
import com.newstudent.newstudent.Model.Division;
import com.newstudent.newstudent.Model.Student;
import com.newstudent.newstudent.Model.Subject;
import com.newstudent.newstudent.Repository.DivisionRepository;
import com.newstudent.newstudent.Service.DivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DivisionController {
    @Autowired
    private DivisionService divisionService;

    @PostMapping("/addDivision")
    public ResponseEntity<Division> saveDivision(@RequestBody Division division)
    {
        divisionService.saveDivision(division);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @GetMapping("/getDivisions")
    public ResponseEntity<List<Division>> getDivisions()
    {
        return new ResponseEntity<>(divisionService.getDivisions(), HttpStatus.OK);
    }


    @DeleteMapping("/deleteDivision/{divId}")
    public ResponseEntity deleteDivision(@PathVariable int divId)
    {
        divisionService.deleteDivision(divId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/getDivisions/{classId}")
    public List<Division> getDivisions(@PathVariable int classId)
    {
        return divisionService.getAllDivisions(classId);
    }


}
