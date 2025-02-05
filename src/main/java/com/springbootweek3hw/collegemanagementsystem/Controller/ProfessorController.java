package com.springbootweek3hw.collegemanagementsystem.Controller;


import com.springbootweek3hw.collegemanagementsystem.Entities.ProfessorEntity;
import com.springbootweek3hw.collegemanagementsystem.Services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/professors")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @PostMapping("/save")
    public ProfessorEntity saveProfessor(@RequestBody ProfessorEntity professorEntity)
    {
        return professorService.saveProfessor(professorEntity);
    }

    @GetMapping("/get/{professorId}")
    public Optional<ProfessorEntity> getStudentById(@PathVariable  long professorId)
    {
        return professorService.getProfessor(professorId);
    }

    @PutMapping("/{professorId}/students/{studentId}")
    public ProfessorEntity assignStudentToProfessor(@PathVariable long professorId, @PathVariable long studentId)
    {
        return professorService.assignStudentToProfessor(professorId,studentId);
    }

    @PutMapping("/{professorId}/subjects/{subjectId}")
    public ProfessorEntity assignSubjectToProfessor(@PathVariable long professorId, @PathVariable long subjectId)
    {
        return professorService.assignSubjectToProfessor(professorId,subjectId);
    }

}
