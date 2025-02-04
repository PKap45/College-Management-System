package com.springbootweek3hw.collegemanagementsystem.Controller;

import com.springbootweek3hw.collegemanagementsystem.Entities.AdmissionRecordEntity;
import com.springbootweek3hw.collegemanagementsystem.Repositories.AdmissionRecordRepository;
import com.springbootweek3hw.collegemanagementsystem.Services.AdmissionRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/admissionRecord")
public class AdmissionRecordController {

    @Autowired
    private AdmissionRecordService admissionRecordService;

    @PostMapping("/save")
    public AdmissionRecordEntity saveAdmissionRecord(@RequestBody AdmissionRecordEntity admissionRecordEntity)
    {
        return admissionRecordService.saveAdmissionRecord(admissionRecordEntity);
    }

    @GetMapping("/get/{admissionRecordId}")
    public Optional<AdmissionRecordEntity> getAdmissionRecordById(@PathVariable long admissionRecordId)
    {
        return admissionRecordService.getAdmissionRecord(admissionRecordId);
    }

}
