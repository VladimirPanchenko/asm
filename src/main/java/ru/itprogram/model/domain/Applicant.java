package ru.itprogram.model.domain;

import java.util.Objects;

public class Applicant {
    private long id;
    private String name;
    private String surname;
    private String middleName;
    private short age;
    private Gender gender;
    private Profession profession;
    private Experience experience;

    public Applicant() {
    }

    public Applicant(long id, String name, String surname, String middleName,
                     short age, Gender gender, Profession profession, Experience experience) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.middleName = middleName;
        this.age = age;
        this.gender = gender;
        this.profession = profession;
        this.experience = experience;
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

    public Profession getProfession() {
        return profession;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
    }

    public Experience getExperience() {
        return experience;
    }

    public void setExperience(Experience experience) {
        this.experience = experience;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Applicant that = (Applicant) o;
        return id == that.id &&
                age == that.age &&
                Objects.equals(name, that.name) &&
                Objects.equals(surname, that.surname) &&
                Objects.equals(middleName, that.middleName) &&
                gender == that.gender &&
                Objects.equals(profession, that.profession) &&
                Objects.equals(experience, that.experience);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, middleName, age, gender, profession, experience);
    }

    @Override
    public String toString() {
        return "Applicant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", middleName='" + middleName + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", profession=" + profession +
                ", experience=" + experience +
                '}';
    }
}
