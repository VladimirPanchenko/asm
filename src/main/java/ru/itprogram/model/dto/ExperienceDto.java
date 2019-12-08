package ru.itprogram.model.dto;

import java.util.Objects;

public class ExperienceDto {
    private long id;
    private short professionTime;

    public ExperienceDto() {
    }

    public ExperienceDto(long id, short professionTime) {
        this.id = id;
        this.professionTime = professionTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public short getProfessionTime() {
        return professionTime;
    }

    public void setProfessionTime(short professionTime) {
        this.professionTime = professionTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExperienceDto that = (ExperienceDto) o;
        return id == that.id &&
                professionTime == that.professionTime;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, professionTime);
    }

    @Override
    public String toString() {
        return "ExperienceDto{" +
                "id=" + id +
                ", professionTime=" + professionTime +
                '}';
    }
}
