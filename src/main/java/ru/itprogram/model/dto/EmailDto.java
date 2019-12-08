package ru.itprogram.model.dto;

import java.util.Objects;

public class EmailDto {
    private long id;
    private long applicantId;
    private String email;

    public EmailDto() {
    }

    public EmailDto(long id, long applicantId, String email) {
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
        EmailDto emailDto = (EmailDto) o;
        return id == emailDto.id &&
                applicantId == emailDto.applicantId &&
                Objects.equals(email, emailDto.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, applicantId, email);
    }

    @Override
    public String toString() {
        return "EmailDto{" +
                "id=" + id +
                ", applicantId=" + applicantId +
                ", email='" + email + '\'' +
                '}';
    }
}
