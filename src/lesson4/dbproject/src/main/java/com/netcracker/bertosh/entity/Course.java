package com.netcracker.bertosh.entity;

import java.util.Objects;

public class Course {
    private long id;
    private String name;
    private String trainerName;
    private String trainerSurname;
    private int hoursCount;

    public Course() {

    }

    public Course(long id, String name, String trainerName, String trainerSurname, int hoursCount) {
        this.id = id;
        this.name = name;
        this.trainerName = trainerName;
        this.trainerSurname = trainerSurname;
        this.hoursCount = hoursCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getHoursCount() {
        return hoursCount;
    }

    public long getId() {
        return id;
    }

    public String getTrainerName() {
        return trainerName;
    }

    public String getTrainerSurname() {
        return trainerSurname;
    }

    public void setHoursCount(int hoursCount) {
        this.hoursCount = hoursCount;
    }

    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }

    public void setTrainerSurname(String trainerSurname) {
        this.trainerSurname = trainerSurname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return id == course.id &&
                Objects.equals(name, course.name) &&
                Objects.equals(trainerName, course.trainerName) &&
                Objects.equals(trainerSurname, course.trainerSurname) &&
                hoursCount == course.hoursCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, trainerName, trainerSurname, hoursCount);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Course{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", trainerName='").append(trainerName).append('\'');
        sb.append(", trainerSurname='").append(trainerSurname).append('\'');
        sb.append(", hoursCount=").append(hoursCount);
        sb.append('}');
        return sb.toString();
    }
}
