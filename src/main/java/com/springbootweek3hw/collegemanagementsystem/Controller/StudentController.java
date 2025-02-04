package com.springbootweek3hw.collegemanagementsystem.Controller;

import com.springbootweek3hw.collegemanagementsystem.Entities.StudentEntity;
import com.springbootweek3hw.collegemanagementsystem.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/save")
    public StudentEntity saveStudent(@RequestBody StudentEntity studentEntity)
    {
        return studentService.saveStudent(studentEntity);
    }

    @GetMapping("/get/{studentId}")
    public Optional<StudentEntity> getStudentById(@PathVariable  long studentId)
    {
        return studentService.getStudent(studentId);
    }

    @PutMapping("/{studentId}/admissionRecord/{admissionRecordId}")
    public StudentEntity assignedAdmissionRecordToStudent(@PathVariable long studentId ,@PathVariable long admissionRecordId)
    {
        return studentService.assignedAdmissionRecordToStudent(studentId,admissionRecordId);
    }



}
