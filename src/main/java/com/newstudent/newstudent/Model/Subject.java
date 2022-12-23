package com.newstudent.newstudent.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "subject")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int subId;

    @Column(name = "sub_Name")
    private String subName;

    @JsonIgnore
    @ManyToMany(mappedBy = "assignedSubjects")
    private List<Student> stu;
}
