package com.design.mvp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.design.mvp.dto.ProjectDTO;
import com.design.mvp.entities.Project;
import com.design.mvp.services.ProjectService;

@RestController
@RequestMapping("/project")
public class ProjectController {
	
	@Autowired
	ProjectService projectService;

    @PostMapping
    Project newUsuario(@RequestBody ProjectDTO newProject) {
        return projectService.saveProject(newProject);
    }

}
