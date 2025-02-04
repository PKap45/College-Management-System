package com.springbootweek3hw.collegemanagementsystem.Repositories;

import com.springbootweek3hw.collegemanagementsystem.Entities.AdmissionRecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdmissionRecordRepository extends JpaRepository<AdmissionRecordEntity,Long> {
}
