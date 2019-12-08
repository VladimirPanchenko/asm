package ru.itprogram.model.domain;

import java.util.Objects;

public class Phone {
    private long id;
    private long applicantId;
    private String number;

    public Phone() {
    }

    public Phone(long id, long applicantId, String number) {
        this.id = id;
        this.applicantId = applicantId;
        this.number = number;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(long applicantId) {
        this.applicantId = applicantId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Phone that = (Phone) o;
        return id == that.id &&
                applicantId == that.applicantId &&
                Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, applicantId, number);
    }

    @Override
    public String toString() {
        return "Phone{" +
                "id=" + id +
                ", applicantId=" + applicantId +
                ", number='" + number + '\'' +
                '}';
    }
}
