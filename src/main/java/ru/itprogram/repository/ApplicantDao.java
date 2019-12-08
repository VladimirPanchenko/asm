package ru.itprogram.repository;

import ru.itprogram.model.domain.Applicant;

import java.util.List;

public interface ApplicantDao {
    List<Applicant> getAll();
    Applicant getById(long id);
    void add(Applicant applicant);
    void update(Applicant applicant);
    void remove(long id);
}
