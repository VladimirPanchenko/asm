package ru.itprogram.service.impl;

import ru.itprogram.config.MapperConfiguration;
import ru.itprogram.model.domain.Phone;
import ru.itprogram.model.dto.PhoneDto;
import ru.itprogram.repository.impl.PhoneRepositoryImpl;
import ru.itprogram.service.PhoneService;

import java.util.List;

public class PhoneServiceImpl implements PhoneService {

    private MapperConfiguration mapper;
    private PhoneRepositoryImpl phoneRepository;

    public PhoneServiceImpl() {
        this.mapper = new MapperConfiguration();
        this.phoneRepository = new PhoneRepositoryImpl();
    }

    @Override
    public List<PhoneDto> getAllPhone() {
        return mapper.mapAsList(phoneRepository.getAll(), PhoneDto.class);
    }

    @Override
    public PhoneDto findPhoneByApplicantId(long id) {
        return null;
    }

    @Override
    public void saveNewPhone(PhoneDto phoneDto) {
        phoneRepository.add(mapper.map(phoneDto, Phone.class));
    }

    @Override
    public void deletePhoneById(long id) {
        phoneRepository.remove(id);
    }
}
