package ru.itprogram.repository;

import ru.itprogram.model.domain.Experience;

import java.util.List;

public interface ExperienceDao {
    List<Experience> getAll();
    Experience getById(long id);
    Experience getByProfessionTime(short professionTime);
    void add(Experience experience);
    void update(Experience experience);
    void remove(long id);
}
