package ru.itprogram.service;

import ru.itprogram.model.dto.ExperienceDto;

import java.util.List;

public interface ExperienceService {
    List<ExperienceDto> getAllExperience();
    ExperienceDto findExperienceById(long id);
    void saveNewExperience(ExperienceDto experienceDto);
    void updateExperience(ExperienceDto experienceDto);
    void deleteExperienceById(long id);
}
