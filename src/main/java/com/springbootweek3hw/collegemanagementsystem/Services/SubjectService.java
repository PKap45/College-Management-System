package com.springbootweek3hw.collegemanagementsystem.Services;

import com.springbootweek3hw.collegemanagementsystem.Entities.SubjectEntity;
import com.springbootweek3hw.collegemanagementsystem.Repositories.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    public Optional<SubjectEntity> getSubjectById(long subjectId) {
        return subjectRepository.findById(subjectId);
    }

    public SubjectEntity saveSubject(SubjectEntity subjectEntity) {
        return subjectRepository.save(subjectEntity);
    }
}
