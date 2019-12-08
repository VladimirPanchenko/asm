package ru.itprogram.repository;

import ru.itprogram.model.domain.Phone;

import java.util.List;

public interface PhoneDao {
    List<Phone> getAll();
    List<Phone> getByApplicantId(long id);
    void add(Phone phone);
    void remove(long id);
}
