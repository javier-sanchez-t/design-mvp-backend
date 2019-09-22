package com.design.mvp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.design.mvp.entities.Project;
import com.design.mvp.entities.Version;


@Repository
public interface VersionRepository extends JpaRepository<Version,Long>{
	Version findTop1ByProjectOrderByIdVersionDesc(Project project);
	
	@Query("select new com.design.mvp.entities.Version(u.idVersion, u.version) from Version u where u.project = ?1 order by u.idVersion")
	List<Version> findByProject(Project project);
	
	@Modifying
	@Transactional
	@Query("update Version v set v.approved = ?1 where v.idVersion = ?2")
	int approveVersion(boolean status, Long idVersion);
	
	@Query("select count(v) from Version v where v.project = ?1")
	int numVersionsByProject(Project project);
	
	Version findByProjectAndVersion(Project project, String version);
}
