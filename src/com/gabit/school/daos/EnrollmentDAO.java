package com.gabit.school.daos;

import com.gabit.school.models.EnrollmentModel;

import java.util.List;

public interface EnrollmentDAO extends CRUD<EnrollmentModel, EnrollmentModel.IdEnrollment> {

    List<EnrollmentModel> getByStudent(long idStudent) throws DAOException;

    List<EnrollmentModel> getBySubject(long idSubject) throws DAOException;

    List<EnrollmentModel> getByCourse(int idCourse) throws DAOException;
}
