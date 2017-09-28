package com.yogop.dbprojectapi.repository;

import com.yogop.dbprojectapi.model.Project;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Jeffrey Y. Pogoy
 * @created 14 Sep 2017 11:25 AM
 */
@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

    @Query("SELECT p FROM project p WHERE p.name LIKE %:keyword% OR p.description LIKE %:keyword%")
    List<Project> findByKeyword(@Param("keyword") String keyword, Pageable pageable);

    @Query("SELECT COUNT(p) FROM project p WHERE p.name LIKE %:keyword% OR p.description LIKE %:keyword%")
    int countByKeyword(@Param("keyword") String keyword);

}