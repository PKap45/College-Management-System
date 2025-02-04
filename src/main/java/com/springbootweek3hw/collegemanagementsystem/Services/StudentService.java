package com.springbootweek3hw.collegemanagementsystem.Services;

import com.springbootweek3hw.collegemanagementsystem.Entities.AdmissionRecordEntity;
import com.springbootweek3hw.collegemanagementsystem.Entities.ProfessorEntity;
import com.springbootweek3hw.collegemanagementsystem.Entities.StudentEntity;
import com.springbootweek3hw.collegemanagementsystem.Repositories.AdmissionRecordRepository;
import com.springbootweek3hw.collegemanagementsystem.Repositories.ProfessorRepository;
import com.springbootweek3hw.collegemanagementsystem.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private AdmissionRecordRepository admissionRecordRepository;

    @Autowired
    private ProfessorRepository professorRepository;
    public StudentEntity saveStudent(StudentEntity studentEntity) {
       return studentRepository.save(studentEntity);
    }

    public Optional<StudentEntity> getStudent(long studentId) {

      return studentRepository.findById(studentId);
    }

    public StudentEntity assignedAdmissionRecordToStudent(long studentId, long admissionRecordId) {

        Optional<StudentEntity> studentEntity = studentRepository.findById(studentId);
        Optional<AdmissionRecordEntity> admissionRecordEntity = admissionRecordRepository.findById(admissionRecordId);

        return studentEntity.flatMap(
                student -> (
                        admissionRecordEntity.map( admissionRecord ->{
                            student.setAdmissionRecord(admissionRecord);
                           return studentRepository.save(student);
                        }))).orElse(null);

    }

    }
