package com.gabit.school.daos.mysql;

import com.gabit.school.daos.EnrollmentDAO;
import com.gabit.school.models.EnrollmentModel;

import java.sql.Connection;
import java.util.List;

public class MySQLEnrollmentDAO implements EnrollmentDAO {

    private Connection conn;

    public MySQLEnrollmentDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void create(EnrollmentModel element) {

    }

    @Override
    public EnrollmentModel readOne(Long id) {
        return null;
    }

    @Override
    public List<EnrollmentModel> readAll() {
        return null;
    }

    @Override
    public void update(EnrollmentModel element) {

    }

    @Override
    public void delete(EnrollmentModel element) {

    }
}
