package ru.itprogram.model.domain;

import java.util.Objects;

public class Experience {
    private long id;
    private short professionTime;

    public Experience() {
    }

    public Experience(long id, short professionTime) {
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
        Experience that = (Experience) o;
        return id == that.id &&
                professionTime == that.professionTime;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, professionTime);
    }

    @Override
    public String toString() {
        return "Experience{" +
                "id=" + id +
                ", professionTime=" + professionTime +
                '}';
    }
}
