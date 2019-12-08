package ru.itprogram.model.dto;

import ru.itprogram.model.domain.Gender;

import java.util.Objects;

public class ApplicantDto {
    private long id;
    private String name;
    private String surname;
    private String middleName;
    private short age;
    private Gender gender;
    private ProfessionDto professionDto;
    private ExperienceDto experienceDto;

    public ApplicantDto() {
    }

    public ApplicantDto(long id, String name, String surname, String middleName,
                        short age, Gender gender, ProfessionDto professionDto, ExperienceDto experienceDto) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.middleName = middleName;
        this.age = age;
        this.gender = gender;
        this.professionDto = professionDto;
        this.experienceDto = experienceDto;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public short getAge() {
        return age;
    }

    public void setAge(short age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public ProfessionDto getProfessionDto() {
        return professionDto;
    }

    public void setProfessionDto(ProfessionDto professionDto) {
        this.professionDto = professionDto;
    }

    public ExperienceDto getExperienceDto() {
        return experienceDto;
    }

    public void setExperienceDto(ExperienceDto experienceDto) {
        this.experienceDto = experienceDto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ApplicantDto that = (ApplicantDto) o;
        return id == that.id &&
                age == that.age &&
                Objects.equals(name, that.name) &&
                Objects.equals(surname, that.surname) &&
                Objects.equals(middleName, that.middleName) &&
                gender == that.gender &&
                Objects.equals(professionDto, that.professionDto) &&
                Objects.equals(experienceDto, that.experienceDto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, middleName, age, gender, professionDto, experienceDto);
    }

    @Override
    public String toString() {
        return "ApplicantDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", middleName='" + middleName + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", professionDto=" + professionDto +
                ", experienceDto=" + experienceDto +
                '}';
    }
}
