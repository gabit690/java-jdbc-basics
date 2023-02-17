package com.gabit.school.models;

public class EnrollmentModel {

    private long Student;

    private long Subject;

    private int year;

    private Integer note;

    public EnrollmentModel(long student, long subject, int year, Integer note) {
        Student = student;
        Subject = subject;
        this.year = year;
        this.note = note;
    }

    public long getStudent() {
        return Student;
    }

    public void setStudent(long student) {
        Student = student;
    }

    public long getSubject() {
        return Subject;
    }

    public void setSubject(long subject) {
        Subject = subject;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Integer getNote() {
        return note;
    }

    public void setNote(Integer note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Enrollment{" +
                "Student=" + Student +
                ", Subject=" + Subject +
                ", year=" + year +
                ", note=" + note +
                '}';
    }
}
