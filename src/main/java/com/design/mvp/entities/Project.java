package com.design.mvp.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the projects database table.
 * 
 */
@Entity
@Table(name="projects")
@NamedQuery(name="Project.findAll", query="SELECT p FROM Project p")
public class Project implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_project")
	private Long idProject;

	private String name;

	/*//bi-directional many-to-one association to Comment
	@OneToMany(mappedBy="project")
	private List<Comment> comments;

	//bi-directional many-to-one association to Version
	@OneToMany(mappedBy="project")
	private List<Version> versions;*/

	public Project() {
	}

	public Long getIdProject() {
		return this.idProject;
	}

	public void setIdProject(Long idProject) {
		this.idProject = idProject;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/*public List<Comment> getComments() {
		return this.comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Comment addComment(Comment comment) {
		getComments().add(comment);
		comment.setProject(this);

		return comment;
	}

	public Comment removeComment(Comment comment) {
		getComments().remove(comment);
		comment.setProject(null);

		return comment;
	}

	public List<Version> getVersions() {
		return this.versions;
	}

	public void setVersions(List<Version> versions) {
		this.versions = versions;
	}

	public Version addVersion(Version version) {
		getVersions().add(version);
		version.setProject(this);

		return version;
	}

	public Version removeVersion(Version version) {
		getVersions().remove(version);
		version.setProject(null);

		return version;
	}*/

}