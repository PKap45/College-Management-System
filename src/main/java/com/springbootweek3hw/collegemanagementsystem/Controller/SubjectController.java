package com.springbootweek3hw.collegemanagementsystem.Controller;

import com.springbootweek3hw.collegemanagementsystem.Entities.SubjectEntity;
import com.springbootweek3hw.collegemanagementsystem.Services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/subjects")
@RestController
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @PostMapping("/save")
    public SubjectEntity saveSubjects(@RequestBody SubjectEntity subjectEntity)
    {
        return subjectService.saveSubject(subjectEntity);
    }

    @GetMapping("/get/{subjectId}")
    public Optional<SubjectEntity> getSubjects(@PathVariable long subjectId)
    {
        return subjectService.getSubjectById(subjectId);
    }
}
