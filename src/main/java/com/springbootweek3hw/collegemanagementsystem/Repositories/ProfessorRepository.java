package com.springbootweek3hw.collegemanagementsystem.Repositories;

import com.springbootweek3hw.collegemanagementsystem.Entities.ProfessorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<ProfessorEntity,Long> {
}
