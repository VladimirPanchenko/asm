package ru.itprogram.model.domain;

public enum  Gender {
    MAN ("Мужчина"),
    WOMAN ("Женщина");

    private String gender;

    Gender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "Gender{" +
                "gender='" + gender + '\'' +
                '}';
    }
}
