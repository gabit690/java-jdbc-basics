package com.gabit.school.daos.mysql;

import com.gabit.school.daos.DAOException;
import com.gabit.school.daos.EnrollmentDAO;
import com.gabit.school.models.EnrollmentModel;

import java.sql.*;
import java.util.List;

public class MySQLEnrollmentDAO implements EnrollmentDAO {

    private Connection connection;

    public MySQLEnrollmentDAO(Connection conn) {
        this.connection = conn;
    }

    @Override
    public void create(EnrollmentModel element) throws DAOException {
        String insertQuery = "INSERT INTO enrollments (student, subject, date, note) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS)) {
            statement.setLong(1, element.getId().getStudent());
            statement.setLong(2, element.getId().getSubject());
            statement.setInt(3, element.getId().getYear());

            if (element.getNote() != null) {
                statement.setInt(4, element.getNote());
            } else {
                statement.setNull(4, Types.INTEGER);
            }

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected == 0) {
                throw new DAOException("Insertion failed");
            }

        } catch (SQLException e) {
            throw new DAOException("Error in SQL", e);
        }
    }

    @Override
    public EnrollmentModel readOne(EnrollmentModel.IdEnrollment id) throws DAOException {
        return null;
    }

    @Override
    public List<EnrollmentModel> readAll() throws DAOException {
        return null;
    }

    @Override
    public void update(EnrollmentModel element) throws DAOException {

    }

    @Override
    public void delete(EnrollmentModel element) throws DAOException {

    }

    @Override
    public List<EnrollmentModel> getByStudent(long idStudent) throws DAOException {
        return null;
    }

    @Override
    public List<EnrollmentModel> getBySubject(long idSubject) throws DAOException {
        return null;
    }

    @Override
    public List<EnrollmentModel> getByCourse(int idCourse) throws DAOException {
        return null;
    }

    private EnrollmentModel convert(ResultSet rs) throws SQLException {
        long student = rs.getLong("student");
        long subject = rs.getLong("subject");
        int year = rs.getInt("date");
        Integer note = rs.getInt("note");
        if (rs.wasNull()) {
            note = null;
        }
        EnrollmentModel enrollment = new EnrollmentModel(student, student, year);
        enrollment.setNote(note);
        return enrollment;
    }
}
