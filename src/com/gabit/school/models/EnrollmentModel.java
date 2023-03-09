package com.gabit.school.models;

public class EnrollmentModel {

    public class IdEnrollment {

        private long student;

        private long subject;

        private int year;

        public IdEnrollment(long student, long subject, int year) {
            this.student = student;
            this.subject = subject;
            this.year = year;
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
            this.subject = subject;
        }

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }
    }

    private IdEnrollment id;

    private Integer note = null;

    public EnrollmentModel(IdEnrollment id) {
        this.id = id;
    }

    public EnrollmentModel(long student, long subject, int year) {
        this.id = new IdEnrollment(student, subject, year);
    }

    public IdEnrollment getId() {
        return id;
    }

    public void setId(IdEnrollment id) {
        this.id = id;
    }

    public Integer getNote() {
        return note;
    }

    public void setNote(Integer note) {
        this.note = note;
    }
}
