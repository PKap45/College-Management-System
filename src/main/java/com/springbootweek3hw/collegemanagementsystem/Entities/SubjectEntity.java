package com.springbootweek3hw.collegemanagementsystem.Entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ManyToAny;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "subjects")
public class SubjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;

    @ManyToMany(mappedBy = "subjectsAlloted",fetch = FetchType.LAZY)
    @JsonIgnoreProperties("subjectsAlloted")
    private List<StudentEntity> studentsAlloted;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "subject_id")
    @JsonIgnoreProperties("subjectAssigned")
    private ProfessorEntity professorAssigned;
}
