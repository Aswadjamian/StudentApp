package com.newstudent.newstudent.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "class")
public class Class {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int classId;

    @Column(name = "class_name")
    private int className;

    //@JsonBackReference(value = "classId")
    @ManyToMany( fetch = FetchType.LAZY)
    @JoinTable(name = "class_div",
            joinColumns = {@JoinColumn(name = "classId")},
            inverseJoinColumns = {@JoinColumn(name = "divId")}
    )
    @JsonIgnore
    private List<Division> divisions;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "classObj")
    private List<Student> students;

}
