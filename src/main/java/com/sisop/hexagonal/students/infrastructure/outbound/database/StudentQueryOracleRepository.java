package com.sisop.hexagonal.students.infrastructure.outbound.database;

import com.sisop.hexagonal.students.domain.model.StudentQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentQueryOracleRepository extends JpaRepository<StudentQuery, Long>{

    String students = "SELECT * FROM VALUMNOS a";
    String studentById = students + " WHERE a.ID_USUARIO = ?1";

    @Query(value = students, nativeQuery = true)
    List<StudentQuery> findAllStudents();

    @Query(value = studentById, nativeQuery = true)
    StudentQuery findStudentById(String id);

}
