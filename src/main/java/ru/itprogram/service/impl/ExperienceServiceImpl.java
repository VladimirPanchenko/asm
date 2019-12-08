package ru.itprogram.service.impl;

import ru.itprogram.config.MapperConfiguration;
import ru.itprogram.model.domain.Experience;
import ru.itprogram.model.dto.ExperienceDto;
import ru.itprogram.repository.impl.ExperienceRepositoryImpl;
import ru.itprogram.service.ExperienceService;

import java.util.List;

public class ExperienceServiceImpl implements ExperienceService {

    private MapperConfiguration mapper;
    private ExperienceRepositoryImpl experienceRepository;

    public ExperienceServiceImpl() {
        this.mapper = new MapperConfiguration();
        this.experienceRepository = new ExperienceRepositoryImpl();
    }

    @Override
    public List<ExperienceDto> getAllExperience() {
        return mapper.mapAsList(experienceRepository.getAll(), ExperienceDto.class);
    }

    @Override
    public ExperienceDto findExperienceById(long id) {
        return mapper.map(experienceRepository.getById(id), ExperienceDto.class);
    }

    @Override
    public void saveNewExperience(ExperienceDto experienceDto) {
        experienceRepository.add(mapper.map(experienceDto, Experience.class));
    }

    @Override
    public void updateExperience(ExperienceDto experienceDto) {
        experienceRepository.update(mapper.map(experienceDto, Experience.class));
    }

    @Override
    public void deleteExperienceById(long id) {
        experienceRepository.remove(id);
    }
}
