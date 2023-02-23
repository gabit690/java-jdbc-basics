package com.gabit.school.daos.mysql;

import com.gabit.school.daos.DAOException;
import com.gabit.school.daos.SubjectDAO;
import com.gabit.school.models.SubjectModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLSubjectDAO implements SubjectDAO {

    private Connection connection;

    public MySQLSubjectDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(SubjectModel element) throws DAOException {
        String insertQuery = "INSERT INTO subjects (name, teacher) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, element.getName());
            statement.setLong(2, element.getIdTeacher());
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected == 0) {
                throw new DAOException("Insertion failed");
            }
            try (ResultSet rs = statement.getGeneratedKeys()) {
                if (rs.next()) {
                    element.setId(rs.getLong(1));
                } else {
                    throw new DAOException("It was not possible to assign a new SUBJECT with this ID.");
                }
            }
        } catch (SQLException e) {
            throw new DAOException("Error in SQL", e);
        }
    }

    @Override
    public SubjectModel readOne(Long id) throws DAOException {
        String getOneQuery = "SELECT id_subject, name, teacher FROM students WHERE id_subject = ?";
        try (PreparedStatement statement = connection.prepareStatement(getOneQuery)) {
            statement.setLong(1, id);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    return convert(rs);
                } else {
                    throw new DAOException("There is no SUBJECT with that id");
                }
            }
        } catch (SQLException e) {
            throw new DAOException("Error in SQL", e);
        }
    }

    @Override
    public List<SubjectModel> readAll() throws DAOException {
        String getAllQuery = "SELECT id_subject, name, teacher FROM students";
        try (PreparedStatement statement = connection.prepareStatement(getAllQuery)) {
            try (ResultSet rs = statement.executeQuery()) {
                List<SubjectModel> subjects = new ArrayList<>();
                while (rs.next()) {
                    subjects.add(convert(rs));
                }
                return subjects;
            }
        } catch (SQLException e) {
            throw new DAOException("Error in SQL", e);
        }
    }

    @Override
    public void update(SubjectModel element) throws DAOException {
        String updateQuery = "UPDATE subjects SET name = ?, teacher = ? WHERE id_subject = ?";
        try (PreparedStatement statement = connection.prepareStatement(updateQuery)) {
            statement.setString(1, element.getName());
            statement.setLong(2, element.getIdTeacher());
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
    public void delete(SubjectModel element) throws DAOException {
        String deleteQuery = "DELETE FROM subjects WHERE id_subject = ?";
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

    private SubjectModel convert(ResultSet rs) throws SQLException {
        String name = rs.getString("name");
        Long idTeacher = rs.getLong("teacher");
        SubjectModel subject = new SubjectModel(name, idTeacher);
        subject.setId(rs.getLong("id_subject"));
        return subject;
    }
}
