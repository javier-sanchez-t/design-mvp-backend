package com.design.mvp.dto;

public class ProjectDTO {
	private String projectName;
	private byte[] initialDesign;

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public byte[] getInitialDesign() {
		return initialDesign;
	}

	public void setInitialDesign(byte[] initialdesign) {
		this.initialDesign = initialdesign;
	}

}
