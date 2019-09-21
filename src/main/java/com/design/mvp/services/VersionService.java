package com.design.mvp.services;

import com.design.mvp.dto.VersionDTO;

public interface VersionService {
	VersionDTO getLatestVersion(String projectName);
	
	boolean approveVersion(Long idVersion, boolean status);
}
