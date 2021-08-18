package com.example.demo.repository;

import com.example.demo.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

    @Query("" +
            "SELECT CASE WHEN COUNT(p) > 0 THEN " +
            "TRUE ELSE FALSE END " +
            "FROM Project p " +
            "WHERE p.id = ?1"
    )
    Boolean selectExistsProject(Long id);

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Modifying(clearAutomatically = true)
    @Query("UPDATE Project " +
            "SET name = ?2, " +
            "projectNo = ?3, " +
            "projectCode = ?4 " +
            "WHERE id = ?1")
    void updateProject(Long id, String name, String projectNo, String projectCode);
}
