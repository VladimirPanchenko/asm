package ru.itprogram.model.domain;

import java.util.Objects;

public class Profession {
    private long id;
    private String professionName;

    public Profession() {
    }

    public Profession(long id, String professionName) {
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
        Profession that = (Profession) o;
        return id == that.id &&
                Objects.equals(professionName, that.professionName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, professionName);
    }

    @Override
    public String toString() {
        return "Profession{" +
                "id=" + id +
                ", professionName='" + professionName + '\'' +
                '}';
    }
}
