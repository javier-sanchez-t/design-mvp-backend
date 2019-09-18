package com.design.mvp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.design.mvp.entities.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Long>{
	Project findByName(String name);
}
