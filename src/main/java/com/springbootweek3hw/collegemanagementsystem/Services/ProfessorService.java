package com.springbootweek3hw.collegemanagementsystem.Services;

import com.springbootweek3hw.collegemanagementsystem.Entities.ProfessorEntity;
import com.springbootweek3hw.collegemanagementsystem.Entities.StudentEntity;
import com.springbootweek3hw.collegemanagementsystem.Repositories.ProfessorRepository;
import com.springbootweek3hw.collegemanagementsystem.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private StudentRepository studentRepository;

    public Optional<ProfessorEntity> getProfessor(long professorId) {
        return professorRepository.findById(professorId);
    }

    public ProfessorEntity saveProfessor(ProfessorEntity professorEntity) {
        return professorRepository.save(professorEntity);
    }


    public ProfessorEntity assignStudentToProfessor(long professorId, long studentId) {
        Optional<ProfessorEntity> professorEntity = professorRepository.findById(professorId);
        Optional<StudentEntity> studentEntity = studentRepository.findById(studentId);

        return professorEntity.flatMap(
                professor->(
                        studentEntity.map(
                                student -> {
                                    student.getProfessorAlloted().add(professor);
                                    studentRepository.save(student);
                                    professor.getStudentsAlloted().add(student);
                                    return professor;
                                }))).orElse(null);


//        return studentEntity.flatMap(student->(
//                        professorEntity.map(
//                                professor->{
//                                    professor.getStudentsAlloted().add(student);
//                                    professorRepository.save(professor);
//
//                                    student.getProfessorAlloted().add(professor);
//                                    return student;
//                                }))).orElse(null);
    }
}
