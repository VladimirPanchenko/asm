package ru.itprogram.repository;

import ru.itprogram.model.domain.Email;

import java.util.List;

public interface EmailDao {
    List<Email> getAll();
    List<Email> getByApplicantId(long id);
    void add(Email email);
    void remove(long id);
}
