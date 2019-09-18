package com.design.mvp.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the versions database table.
 * 
 */
@Entity
@Table(name="versions")
@NamedQuery(name="Version.findAll", query="SELECT v FROM Version v")
public class Version implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_version")
	private Long idVersion;

	private Boolean approved;

	private byte[] design;

	private String version;

	//bi-directional many-to-one association to Comment
	@OneToMany(mappedBy="version")
	private List<Comment> comments;

	//bi-directional many-to-one association to Project
	@ManyToOne
	@JoinColumn(name="id_project")
	private Project project;

	public Version() {
	}
	
	public Version(Long idVersion, String version) {
		this.idVersion=idVersion;
		this.version=version;
	}

	public Long getIdVersion() {
		return this.idVersion;
	}

	public void setIdVersion(Long idVersion) {
		this.idVersion = idVersion;
	}

	public Boolean getApproved() {
		return this.approved;
	}

	public void setApproved(Boolean approved) {
		this.approved = approved;
	}

	public byte[] getDesign() {
		return this.design;
	}

	public void setDesign(byte[] design) {
		this.design = design;
	}

	public String getVersion() {
		return this.version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public List<Comment> getComments() {
		return this.comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Comment addComment(Comment comment) {
		getComments().add(comment);
		comment.setVersion(this);

		return comment;
	}

	public Comment removeComment(Comment comment) {
		getComments().remove(comment);
		comment.setVersion(null);

		return comment;
	}

	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

}