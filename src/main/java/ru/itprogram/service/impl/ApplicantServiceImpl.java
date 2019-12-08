package ru.itprogram.service.impl;

import ru.itprogram.config.MapperConfiguration;
import ru.itprogram.model.domain.Applicant;
import ru.itprogram.model.dto.ApplicantDto;
import ru.itprogram.repository.impl.ApplicantRepositoryImpl;
import ru.itprogram.service.ApplicantService;

import java.util.List;

public class ApplicantServiceImpl implements ApplicantService {

    private MapperConfiguration mapper;
    private ApplicantRepositoryImpl applicantRepository;

    public ApplicantServiceImpl() {
        this.mapper = new MapperConfiguration();
        this.applicantRepository = new ApplicantRepositoryImpl();
    }

    @Override
    public List<ApplicantDto> getAllApplicant() {
        return mapper.mapAsList(applicantRepository.getAll(), ApplicantDto.class);
    }

    @Override
    public ApplicantDto findApplicantById(long id) {
        return mapper.map(applicantRepository.getById(id), ApplicantDto.class);
    }

    @Override
    public void saveNewApplicant(ApplicantDto applicantDto) {
        applicantRepository.add(mapper.map(applicantDto, Applicant.class));
    }

    @Override
    public void updateApplicant(ApplicantDto applicantDto) {
        applicantRepository.update(mapper.map(applicantDto, Applicant.class));
    }

    @Override
    public void deleteProfessionById(long id) {
        applicantRepository.remove(id);
    }
}
