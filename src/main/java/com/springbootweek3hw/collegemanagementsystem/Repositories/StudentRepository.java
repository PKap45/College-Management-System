package com.springbootweek3hw.collegemanagementsystem.Repositories;

import com.springbootweek3hw.collegemanagementsystem.Entities.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentEntity,Long> {
}
