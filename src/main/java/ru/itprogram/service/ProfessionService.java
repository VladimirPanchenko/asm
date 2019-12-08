package ru.itprogram.service;

import ru.itprogram.model.dto.ProfessionDto;

import java.util.List;

public interface ProfessionService {
    List<ProfessionDto> getAllProfession();
    ProfessionDto findProfessionById(long id);
    void saveNewProfession(ProfessionDto professionDto);
    void updateProfession(ProfessionDto professionDto);
    void deleteProfessionById(long id);
}
