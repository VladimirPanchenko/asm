package ru.itprogram.model.dto;

import java.util.Objects;

public class ProfessionDto {
    private long id;
    private String professionName;

    public ProfessionDto() {
    }

    public ProfessionDto(long id, String professionName) {
        this.id = id;
        this.professionName = professionName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProfessionName() {
        return professionName;
    }

    public void setProfessionName(String professionName) {
        this.professionName = professionName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProfessionDto that = (ProfessionDto) o;
        return id == that.id &&
                Objects.equals(professionName, that.professionName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, professionName);
    }

    @Override
    public String toString() {
        return "ProfessionDto{" +
                "id=" + id +
                ", professionName='" + professionName + '\'' +
                '}';
    }
}
