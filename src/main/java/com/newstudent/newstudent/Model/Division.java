package com.newstudent.newstudent.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.hibernate.annotations.Cascade;
import org.hibernate.engine.spi.CascadeStyle;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "division")
public class Division {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int divId;

    @Column(name = "division_name")
    private String divName;

   // @JsonManagedReference(value = "divisions")
    @ManyToMany(mappedBy = "divisions")
    @JsonIgnore
    private List<Class> classes;

    @JsonIgnore
    @OneToMany(mappedBy = "division")
    private List<Student> student;

}
