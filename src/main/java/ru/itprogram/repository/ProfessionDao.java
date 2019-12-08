package ru.itprogram.repository;

import ru.itprogram.model.domain.Profession;

import java.util.List;

public interface ProfessionDao {
    List<Profession> getAll();
    Profession getById(long id);
    Profession getByProfessionName(String professionName);
    void add(Profession profession);
    void update(Profession profession);
    void remove(long id);
}
