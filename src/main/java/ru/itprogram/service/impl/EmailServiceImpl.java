package ru.itprogram.service.impl;

import ru.itprogram.config.MapperConfiguration;
import ru.itprogram.model.domain.Email;
import ru.itprogram.model.dto.EmailDto;
import ru.itprogram.repository.impl.EmailRepositoryImpl;
import ru.itprogram.service.EmailService;

import java.util.List;

public class EmailServiceImpl implements EmailService {

    private MapperConfiguration mapper;
    private EmailRepositoryImpl emailRepository;

    public EmailServiceImpl() {
        this.mapper = new MapperConfiguration();
        this.emailRepository = new EmailRepositoryImpl();
    }

    @Override
    public List<EmailDto> getAllEmail() {
        return mapper.mapAsList(emailRepository.getAll(), EmailDto.class);
    }

    @Override
    public EmailDto findEmailByApplicantId(long id) {
        return null;
    }

    @Override
    public void saveNewEmail(EmailDto emailDto) {
        emailRepository.add(mapper.map(emailDto, Email.class));
    }

    @Override
    public void deleteEmailById(long id) {
        emailRepository.remove(id);
    }
}
