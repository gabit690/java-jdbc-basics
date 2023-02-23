package com.gabit.school.daos.mysql;

import com.gabit.school.daos.DAOManager;
import com.gabit.school.daos.StudentDAO;
import com.gabit.school.daos.TeacherDAO;
import com.gabit.school.daos.SubjectDAO;
import com.gabit.school.daos.EnrollmentDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLDAOManager implements DAOManager {

    private Connection conn;

    private StudentDAO students = null;

    private TeacherDAO teachers = null;

    private SubjectDAO subjects = null;

    private EnrollmentDAO enrollments = null;

    public MySQLDAOManager(String host, String database, String username, String password) throws SQLException {
        this.conn = DriverManager.getConnection("jdbc:mysql://" + host + "/" + database, username, password);
    }

    @Override
    public StudentDAO getStudentDAO() {
        if (students == null) {
            students = new MySQLStudentDAO(conn);
        }
        return students;
    }

    @Override
    public SubjectDAO getSubjectDAO() {
        if (subjects == null) {
            subjects = new MySQLSubjectDAO(conn);
        }
        return subjects;
    }

    @Override
    public TeacherDAO getTeacherDAO() {
        if (teachers == null) {
            teachers = new MySQLTeacherDAO(conn);
        }
        return teachers;
    }

    @Override
    public EnrollmentDAO getEnrollmentDAO() {
        if (enrollments == null) {
            enrollments = new MySQLEnrollmentDAO(conn);
        }
        return enrollments;
    }
}
