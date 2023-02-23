package com.gabit.school.daos.mysql;

import com.gabit.school.daos.DAOException;
import com.gabit.school.daos.TeacherDAO;
import com.gabit.school.models.TeacherModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLTeacherDAO implements TeacherDAO {

    private Connection connection;

    public MySQLTeacherDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(TeacherModel element) throws DAOException {
        String insertQuery = "INSERT INTO teachers (firstname, lastname) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, element.getFirstname());
            statement.setString(2, element.getLastname());
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected == 0) {
                throw new DAOException("Insertion failed");
            }
            try (ResultSet rs = statement.getGeneratedKeys()) {
                if (rs.next()) {
                    element.setId(rs.getLong(1));
                } else {
                    throw new DAOException("It was not possible to assign a new TEACHER with this ID.");
                }
            }
        } catch (SQLException e) {
            throw new DAOException("Error in SQL", e);
        }
    }

    @Override
    public TeacherModel readOne(Long id) throws DAOException {
        String getOneQuery = "SELECT id_teacher, firstname, lastname FROM students WHERE id_teacher = ?";
        try (PreparedStatement statement = connection.prepareStatement(getOneQuery)) {
            statement.setLong(1, id);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    return convert(rs);
                } else {
                    throw new DAOException("There is no TEACHER with that id");
                }
            }
        } catch (SQLException e) {
            throw new DAOException("Error in SQL", e);
        }
    }

    @Override
    public List<TeacherModel> readAll() throws DAOException {
        String getAllQuery = "SELECT id_teacher, firstname, lastname FROM teachers";
        try (PreparedStatement statement = connection.prepareStatement(getAllQuery)) {
            try (ResultSet rs = statement.executeQuery()) {
                List<TeacherModel> teachers = new ArrayList<>();
                while (rs.next()) {
                    teachers.add(convert(rs));
                }
                return teachers;
            }
        } catch (SQLException e) {
            throw new DAOException("Error in SQL", e);
        }
    }

    @Override
    public void update(TeacherModel element) throws DAOException {
        String updateQuery = "UPDATE teachers SET firstname = ?, lastname = ? WHERE id_teacher = ?";
        try (PreparedStatement statement = connection.prepareStatement(updateQuery)) {
            statement.setString(1, element.getFirstname());
            statement.setString(2, element.getLastname());
            statement.setLong(3, element.getId());
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected == 0) {
                throw new DAOException("Update failed");
            }
        } catch (SQLException e) {
            throw new DAOException("Error in SQL", e);
        }
    }

    @Override
    public void delete(TeacherModel element) throws DAOException {
        String deleteQuery = "DELETE FROM teachers WHERE id_teacher = ?";
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

    private TeacherModel convert(ResultSet rs) throws SQLException {
        String firstname = rs.getString("firstname");
        String lastname = rs.getString("lastname");
        TeacherModel teacher = new TeacherModel(firstname, lastname);
        teacher.setId(rs.getLong("id_teacher"));
        return teacher;
    }
}
