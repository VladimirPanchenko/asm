package ru.itprogram.service;

import ru.itprogram.model.dto.EmailDto;

import java.util.List;

public interface EmailService {
    List<EmailDto> getAllEmail();
    EmailDto findEmailByApplicantId(long id);
    void saveNewEmail(EmailDto emailDto);
    void deleteEmailById(long id);
}
