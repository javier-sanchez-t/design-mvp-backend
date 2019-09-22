package com.design.mvp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.design.mvp.dto.VersionDTO;
import com.design.mvp.entities.Version;
import com.design.mvp.services.VersionService;

@RestController
@RequestMapping("/versions")
public class VersionController {
	
	@Autowired
	VersionService versionService;
	
	@GetMapping("/{projectName}")
	VersionDTO getLatestVersion(@PathVariable  String projectName, @RequestParam("version") String version){
		return versionService.getLatestVersion(projectName, version);
	}
	
	@PutMapping("/approve/{idVersion}/{status}")
	boolean approveVersion(@PathVariable  Long idVersion, @PathVariable boolean status) {
		return versionService.approveVersion(idVersion, status);
	}
	
	@PostMapping
	Version saveVersion(@RequestBody Version newVersion) {
		return versionService.saveVersion(newVersion);
	}
	
	
}
