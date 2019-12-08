package ru.itprogram.config;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import ru.itprogram.model.domain.*;
import ru.itprogram.model.dto.*;

public class MapperConfiguration extends ConfigurableMapper {

    @Override
    protected void configure(MapperFactory factory) {
        factory.classMap(Applicant.class, ApplicantDto.class)
                .byDefault()
                .register();

        factory.classMap(Experience.class, ExperienceDto.class)
                .byDefault()
                .register();

        factory.classMap(Profession.class, ProfessionDto.class)
                .byDefault()
                .register();

        factory.classMap(Email.class, EmailDto.class)
                .byDefault()
                .register();

        factory.classMap(Phone.class, PhoneDto.class)
                .byDefault()
                .register();
    }
}
