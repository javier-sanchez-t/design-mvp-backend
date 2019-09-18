package com.design.mvp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.design.mvp.dto.ProjectDTO;
import com.design.mvp.entities.Project;
import com.design.mvp.entities.Version;
import com.design.mvp.error.BusinessLogicException;
import com.design.mvp.repositories.ProjectRepository;
import com.design.mvp.repositories.VersionRepository;

@Service
public class ProjectServiceImpl implements ProjectService{
	
	@Autowired
	ProjectRepository projectrepository;
	
	@Autowired
	VersionRepository versionRepository;

	@Transactional
	@Override
	public Project saveProject(ProjectDTO newProject) {
		Project projectCreated = projectrepository.findByName(newProject.getProjectName());
		
		if(projectCreated!=null) {
			throw new BusinessLogicException("Project name already used.");
		}
		
		Project project = new Project();
		project.setName(newProject.getProjectName());
		projectrepository.save(project);
		
		Version versionOne = new Version();
		versionOne.setVersion("1.0");
		versionOne.setDesign(newProject.getInitialDesign());
		versionOne.setProject(project);
		versionOne.setApproved(false);
		versionRepository.save(versionOne);
		
		return project;
	}

}
