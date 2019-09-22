package com.design.mvp.services;

import com.design.mvp.dto.VersionDTO;
import com.design.mvp.entities.Version;

public interface VersionService {
	VersionDTO getLatestVersion(String projectName, String version);
	
	boolean approveVersion(Long idVersion, boolean status);
	
	Version saveVersion(Version newVersion);
}
