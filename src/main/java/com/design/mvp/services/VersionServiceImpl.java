package com.design.mvp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.design.mvp.dto.VersionDTO;
import com.design.mvp.entities.Project;
import com.design.mvp.entities.Version;
import com.design.mvp.error.BusinessLogicException;
import com.design.mvp.repositories.ProjectRepository;
import com.design.mvp.repositories.VersionRepository;

@Service
public class VersionServiceImpl implements VersionService{
	
	@Autowired
	VersionRepository versionRepository;
	
	@Autowired
	ProjectRepository projectRepository;

	@Override
	public VersionDTO getLatestVersion(String projectName) {
		Project project = projectRepository.findByName(projectName);
		if(project==null) {
			throw new BusinessLogicException("The project does not exist");
		}
		
		Version latestversion = versionRepository.findTop1ByProjectOrderByIdVersionDesc(project);
		List<Version> versions = versionRepository.findByProject(project);
		VersionDTO versionDTO = new VersionDTO();
		versionDTO.setLastVersion(latestversion);
		versionDTO.setVersions(versions);
		
		return versionDTO;
	}

}
