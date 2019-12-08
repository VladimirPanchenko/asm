package ru.itprogram.model.domain;

import java.util.Objects;

public class Email {
    private long id;
    private long applicantId;
    private String email;

    public Email() {
    }

    public Email(long id, long applicantId, String email) {
        this.id = id;
        this.applicantId = applicantId;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Email that = (Email) o;
        return id == that.id &&
                applicantId == that.applicantId &&
                Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, applicantId, email);
    }

    @Override
    public String toString() {
        return "Email{" +
                "id=" + id +
                ", applicantId=" + applicantId +
                ", email='" + email + '\'' +
                '}';
    }
}
