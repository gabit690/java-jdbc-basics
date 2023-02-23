package com.gabit.school.daos;

public interface DAOManager {

    StudentDAO getStudentDAO();

    SubjectDAO getSubjectDAO();

    TeacherDAO getTeacherDAO();

    EnrollmentDAO getEnrollmentDAO();
}
