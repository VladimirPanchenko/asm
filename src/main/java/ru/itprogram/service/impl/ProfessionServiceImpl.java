package ru.itprogram.service.impl;

import ru.itprogram.config.MapperConfiguration;
import ru.itprogram.model.domain.Profession;
import ru.itprogram.model.dto.ProfessionDto;
import ru.itprogram.repository.impl.ProfessionRepositoryImpl;
import ru.itprogram.service.ProfessionService;

import java.util.List;

public class ProfessionServiceImpl implements ProfessionService {

    private MapperConfiguration mapper;
    private ProfessionRepositoryImpl professionRepository;

    public ProfessionServiceImpl() {
        this.mapper = new MapperConfiguration();
        this.professionRepository = new ProfessionRepositoryImpl();
    }

    @Override
    public List<ProfessionDto> getAllProfession() {
        return mapper.mapAsList(professionRepository.getAll(), ProfessionDto.class);
    }

    @Override
    public ProfessionDto findProfessionById(long id) {
        return mapper.map(professionRepository.getById(id), ProfessionDto.class);
    }

    @Override
    public void saveNewProfession(ProfessionDto professionDto) {
        professionRepository.add(mapper.map(professionDto, Profession.class));
    }

    @Override
    public void updateProfession(ProfessionDto professionDto) {
        professionRepository.update(mapper.map(professionDto, Profession.class));
    }

    @Override
    public void deleteProfessionById(long id) {
        professionRepository.remove(id);
    }
}
