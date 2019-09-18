package com.design.mvp.dto;

import java.util.List;

import com.design.mvp.entities.Version;

public class VersionDTO {
	private Version lastVersion;
	private List<Version> versions;

	public Version getLastVersion() {
		return lastVersion;
	}

	public void setLastVersion(Version lastVersion) {
		this.lastVersion = lastVersion;
	}

	public List<Version> getVersions() {
		return versions;
	}

	public void setVersions(List<Version> versions) {
		this.versions = versions;
	}

}
