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
public class VersionServiceImpl implements VersionService {

	@Autowired
	VersionRepository versionRepository;

	@Autowired
	ProjectRepository projectRepository;

	@Override
	public VersionDTO getLatestVersion(String projectName, String version) {
		Project project = projectRepository.findByName(projectName);
		if (project == null) {
			throw new BusinessLogicException("The project does not exist");
		}

		Version latestversion = null;
		if (version.equals("")) {
			latestversion = versionRepository.findTop1ByProjectOrderByIdVersionDesc(project);
		} else {
			latestversion = versionRepository.findByProjectAndVersion(project, version);
		}
		List<Version> versions = versionRepository.findByProject(project);
		VersionDTO versionDTO = new VersionDTO();
		versionDTO.setLastVersion(latestversion);
		versionDTO.setVersions(versions);

		return versionDTO;
	}

	@Override
	public boolean approveVersion(Long idVersion, boolean status) {
		if (versionRepository.approveVersion(status, idVersion) == 1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Version saveVersion(Version newVersion) {
		int numVersions = versionRepository.numVersionsByProject(newVersion.getProject());
		String version = "1." + numVersions;
		newVersion.setVersion(version);
		return versionRepository.save(newVersion);
	}

}
