package com.springbootweek3hw.collegemanagementsystem.Services;

import com.springbootweek3hw.collegemanagementsystem.Entities.AdmissionRecordEntity;
import com.springbootweek3hw.collegemanagementsystem.Repositories.AdmissionRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdmissionRecordService {

    @Autowired
    private AdmissionRecordRepository admissionRecordRepository;

    public AdmissionRecordEntity saveAdmissionRecord(AdmissionRecordEntity admissionRecordEntity) {
        return admissionRecordRepository.save(admissionRecordEntity);
    }

    public Optional<AdmissionRecordEntity> getAdmissionRecord(long admissionRecordId) {
        return admissionRecordRepository.findById(admissionRecordId);
    }
}
