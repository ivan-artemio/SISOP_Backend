package com.sisop.hexagonal.projects.infrastructure.outbound.database;

import com.sisop.hexagonal.projects.domain.model.ProjectQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectQueryOracleRepository extends JpaRepository<ProjectQuery, Long>{

    String projects = "SELECT a.NM_AREA,tp.NM_TIPO,c.NM_CIUDAD,ps.* FROM CL_PROYECTOSERVICIO ps JOIN CL_AREASERVICIO a ON a.ID_AREA = ps.ID_AREA JOIN CL_TIPOPROYECTO tp ON tp.ID_TIPO = ps.ID_TIPO JOIN CL_CIUDAD c ON c.ID_CIUDAD = ps.ID_CIUDAD WHERE ps.CUPO_PROYECTO_PF IS NOT NULL AND ps.CUPO_PROYECTO_PF > 0";
    String projectById = projects + " AND ps.ID_PROYECTO = ?1";

    @Query(value = projects, nativeQuery = true)
    List<ProjectQuery> findAllProjects();

    @Query(value = projectById, nativeQuery = true)
    ProjectQuery findProjectById(Long id);
}
