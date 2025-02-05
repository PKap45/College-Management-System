package com.springbootweek3hw.collegemanagementsystem.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "students")
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @OneToOne
    @JoinColumn(name = "student_admission_record")
    private AdmissionRecordEntity admissionRecord;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "student_professor_mapping",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "professor_id")
    )
    @JsonIgnoreProperties("studentsAlloted")
    private List<ProfessorEntity> professorAlloted;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="students_subject_mapping",
    joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id")
    )
    @JsonIgnoreProperties("studentsAlloted")
    private List<SubjectEntity> subjectsAlloted;



}
