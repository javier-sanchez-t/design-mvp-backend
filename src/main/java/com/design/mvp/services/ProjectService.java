package com.design.mvp.services;

import com.design.mvp.dto.ProjectDTO;
import com.design.mvp.entities.Project;


public interface ProjectService {
	Project saveProject(ProjectDTO newProject);
}
