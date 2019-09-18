package com.design.mvp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.design.mvp.dto.VersionDTO;
import com.design.mvp.services.VersionService;

@RestController
@RequestMapping("/version")
public class VersionController {
	
	@Autowired
	VersionService versionService;
	
	@GetMapping("/{projectName}")
	VersionDTO getLatestVersion(@PathVariable  String projectName){
		return versionService.getLatestVersion(projectName);
	}
	
}
