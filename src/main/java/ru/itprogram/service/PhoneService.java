package ru.itprogram.service;

import ru.itprogram.model.dto.PhoneDto;

import java.util.List;

public interface PhoneService {
    List<PhoneDto> getAllPhone();
    PhoneDto findPhoneByApplicantId(long id);
    void saveNewPhone(PhoneDto phoneDto);
    void deletePhoneById(long id);
}
