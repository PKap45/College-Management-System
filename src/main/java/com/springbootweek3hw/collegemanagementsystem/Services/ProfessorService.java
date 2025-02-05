package com.springbootweek3hw.collegemanagementsystem.Services;

import com.springbootweek3hw.collegemanagementsystem.Entities.ProfessorEntity;
import com.springbootweek3hw.collegemanagementsystem.Entities.StudentEntity;
import com.springbootweek3hw.collegemanagementsystem.Entities.SubjectEntity;
import com.springbootweek3hw.collegemanagementsystem.Repositories.ProfessorRepository;
import com.springbootweek3hw.collegemanagementsystem.Repositories.StudentRepository;
import com.springbootweek3hw.collegemanagementsystem.Repositories.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SubjectRepository subjectRepository;

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

    public ProfessorEntity assignSubjectToProfessor(long professorId, long subjectId) {
        Optional<ProfessorEntity> professorEntity = professorRepository.findById(professorId);
        Optional<SubjectEntity> subjectEntity = subjectRepository.findById(subjectId);

         return professorEntity.flatMap(
                 professor ->(
                         subjectEntity.map( subject ->
                                 {
                                        subject.setProfessorAssigned(professor);
                                        subjectRepository.save(subject);

                                        professor.getSubjectAssigned().add(subject);
                                        return professor;
                                 }))).orElse(null);

    }
}
