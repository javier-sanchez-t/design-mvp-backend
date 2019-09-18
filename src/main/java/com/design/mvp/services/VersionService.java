package com.design.mvp.services;

import com.design.mvp.dto.VersionDTO;

public interface VersionService {
	VersionDTO getLatestVersion(String projectName);
}
