package com.design.mvp.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the comments database table.
 * 
 */
@Entity
@Table(name="comments")
@NamedQuery(name="Comment.findAll", query="SELECT c FROM Comment c")
public class Comment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_comment")
	private Long idComment;

	private String comment;

	private String name;

	//bi-directional many-to-one association to Comment
	@ManyToOne
	@JoinColumn(name="id_reply_comment")
	private Comment commentBean;

	//bi-directional many-to-one association to Comment
	@OneToMany(mappedBy="commentBean")
	private List<Comment> comments;

	//bi-directional many-to-one association to Project
	@ManyToOne
	@JoinColumn(name="id_project")
	private Project project;

	//bi-directional many-to-one association to Version
	@ManyToOne
	@JoinColumn(name="id_version")
	private Version version;

	public Comment() {
	}

	public Long getIdComment() {
		return this.idComment;
	}

	public void setIdComment(Long idComment) {
		this.idComment = idComment;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Comment getCommentBean() {
		return this.commentBean;
	}

	public void setCommentBean(Comment commentBean) {
		this.commentBean = commentBean;
	}

	public List<Comment> getComments() {
		return this.comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Comment addComment(Comment comment) {
		getComments().add(comment);
		comment.setCommentBean(this);

		return comment;
	}

	public Comment removeComment(Comment comment) {
		getComments().remove(comment);
		comment.setCommentBean(null);

		return comment;
	}

	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Version getVersion() {
		return this.version;
	}

	public void setVersion(Version version) {
		this.version = version;
	}

}