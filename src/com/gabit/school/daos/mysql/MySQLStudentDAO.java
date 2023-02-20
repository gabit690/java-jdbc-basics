package com.gabit.school.daos.mysql;

import com.gabit.school.daos.DAOException;
import com.gabit.school.daos.StudentDAO;
import com.gabit.school.models.StudentModel;

import java.sql.*;
import java.util.List;

public class MySQLStudentDAO implements StudentDAO {

    final String insertQuery = "INSERT INTO students(id_student, firstname, lastname, birthdate) VALUES (?, ?, ?, ?, ?)";
    final String updateQuery = "UPDATE students SET firstname = ?, lastname = ?, birthdate = ? WHERE id_students = ?";
    final String deleteQuery = "DELETE FROM students WHERE id_student = ?";
    final String getAllQuery = "SELECT id_students, firstname, lastname, birthdate FROM students";
    final String getOneQuery = "SELECT id_students, firstname, lastname, birthdate FROM students WHERE id_students = ?";






    private Connection connection;

    public MySQLStudentDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(StudentModel element) throws DAOException {
        try (PreparedStatement statement = connection.prepareStatement(insertQuery)) {
            statement.setLong(1, element.getId());
            statement.setString(2, element.getFirstname());
            statement.setString(3, element.getLastname());
            statement.setDate(4, new Date(element.getBirthdate().getTime()));
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected == 0) {
                throw new DAOException("Insertion failed");
            }
        } catch (SQLException e) {
            throw new DAOException("Error in SQL", e);
        }
    }

    private StudentModel convert(ResultSet rs) throws SQLException {
        String firstname = rs.getString("firstname");
        String lastname = rs.getString("lastname");
        Date birthdate = rs.getDate("birthdate");
        StudentModel student = new StudentModel(firstname, lastname, birthdate);
        student.setId(rs.getLong("id_student"));
        return student;
    }


    @Override
    public StudentModel readOne(Long id) throws DAOException{
        try (PreparedStatement statement = connection.prepareStatement(getOneQuery)) {
            statement.setLong(1, id);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    return convert(rs);
                } else {
                    throw new DAOException("There is no student with that id");
                }
            }
        } catch (SQLException e) {
            throw new DAOException("Error in SQL", e);
        }
    }

    @Override
    public List<StudentModel> readAll() {
        return null;
    }

    @Override
    public void update(StudentModel element) throws DAOException {
        try (PreparedStatement statement = connection.prepareStatement(updateQuery)) {
            statement.setString(1, element.getFirstname());
            statement.setString(2, element.getLastname());
            statement.setDate(3, new Date(element.getBirthdate().getTime()));
            statement.setLong(4, element.getId());
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected == 0) {
                throw new DAOException("Update failed");
            }
        } catch (SQLException e) {
            throw new DAOException("Error in SQL", e);
        }
    }

    @Override
    public void delete(StudentModel element) throws DAOException {
        try (PreparedStatement statement = connection.prepareStatement(deleteQuery)) {
            statement.setLong(1, element.getId());
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected == 0) {
                throw new DAOException("Deletion failed");
            }
        } catch (SQLException e) {
            throw new DAOException("Error in SQL", e);
        }
    }
}
