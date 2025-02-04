package com.springbootweek3hw.collegemanagementsystem.Repositories;

import com.springbootweek3hw.collegemanagementsystem.Entities.SubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<SubjectEntity, Long> {
}
