package com.gabit.school.daos.mysql;

import com.gabit.school.daos.StudentDAO;
import com.gabit.school.models.StudentModel;

import java.util.List;

public class MySQLStudentDAO implements StudentDAO {
    @Override
    public void create(StudentModel element) {

    }

    @Override
    public StudentModel readOne(Long id) {
        return null;
    }

    @Override
    public List<StudentModel> readAll() {
        return null;
    }

    @Override
    public void update(StudentModel element) {

    }

    @Override
    public void delete(StudentModel element) {

    }
}
