package com.springbootweek3hw.collegemanagementsystem.Entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "professors")
public class ProfessorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @ManyToMany(mappedBy = "professorAlloted",fetch = FetchType.LAZY)
    @JsonIgnoreProperties("professorAlloted")
    private List<StudentEntity> studentsAlloted;


//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "student_professor_mapping",
//            joinColumns = @JoinColumn(name = "student_id"),
//            inverseJoinColumns = @JoinColumn(name = "professor_id")
//    )
//    @JsonIgnore
//    private List<ProfessorEntity> professorAlloted;
//

}
