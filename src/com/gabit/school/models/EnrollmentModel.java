package com.gabit.school.models;

public class EnrollmentModel {

    private long student;

    private long subject;

    private int year;

    private Integer note;

    public EnrollmentModel(long student, long subject, int year, Integer note) {
        this.student = student;
        this.subject = subject;
        this.year = year;
        this.note = note;
    }

    public long getStudent() {
        return student;
    }

    public void setStudent(long student) {
        this.student = student;
    }

    public long getSubject() {
        return subject;
    }

    public void setSubject(long subject) {
        subject = subject;
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
                "Student=" + student +
                ", Subject=" + subject +
                ", year=" + year +
                ", note=" + note +
                '}';
    }
}
