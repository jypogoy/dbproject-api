package com.yogop.dbprojectapi.repository;

import com.yogop.dbprojectapi.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Jeffrey Y. Pogoy
 * @created 14 Sep 2017 11:25 AM
 */
@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {



}
