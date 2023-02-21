package com.gabit.school.models;

public class SubjectModel {

    private Long id = null;

    private String name;

    private Long idTeacher;

    public SubjectModel(String name, Long idTeacher) {
        this.name = name;
        this.idTeacher = idTeacher;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getIdTeacher() {
        return idTeacher;
    }

    public void setIdTeacher(Long idTeacher) {
        this.idTeacher = idTeacher;
    }

    @Override
    public String toString() {
        return "SubjectModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", idTeacher=" + idTeacher +
                '}';
    }
}
