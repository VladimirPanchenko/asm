package ru.itprogram.service;

import ru.itprogram.model.dto.ApplicantDto;

import java.util.List;

public interface ApplicantService {
    List<ApplicantDto> getAllApplicant();
    ApplicantDto findApplicantById(long id);
    void saveNewApplicant(ApplicantDto applicantDto);
    void updateApplicant(ApplicantDto applicantDto);
    void deleteProfessionById(long id);
}
