package com.sisop.hexagonal.subjects.infrastructure.outbound.database;

import com.sisop.hexagonal.subjects.domain.model.SubjectQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SubjectQueryOracleRepository extends JpaRepository<SubjectQuery, Long> {

    String subjects = "SELECT * FROM VMATERIAS a";
    String subjectByIdUser = subjects + " WHERE a.ID_USUARIO = ?1";

    @Query(value = subjects, nativeQuery = true)
    List<SubjectQuery> findAllSubjects();

    @Query(value = subjectByIdUser, nativeQuery = true)
    List<SubjectQuery> findSubjectsByUserId(String userId);
}
