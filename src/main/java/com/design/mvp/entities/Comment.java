package com.design.mvp.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * The persistent class for the comments database table.
 * 
 */
@Entity
@Table(name = "comments")
@NamedQuery(name = "Comment.findAll", query = "SELECT c FROM Comment c")
public class Comment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_comment")
	private Long idComment;

	private String comment;

	private String name;

	private Integer x;

	private Integer y;

	private Integer width;

	private Integer height;

	private boolean draggable;

	private String stroke;

	private boolean solved;

	//bi-directional many-to-one association to ReplyComment
	@OneToMany(mappedBy="commentBean")
	private List<ReplyComment> replyComments;

	// bi-directional many-to-one association to Comment
	/*
	 * @OneToMany(mappedBy = "commentBean") private List<Comment> comments;
	 */

	// bi-directional many-to-one association to Project
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_project")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Project project;

	// bi-directional many-to-one association to Version
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_version")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
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

	/*
	 * public List<Comment> getComments() { return this.comments; }
	 * 
	 * public void setComments(List<Comment> comments) { this.comments = comments; }
	 * 
	 * public Comment addComment(Comment comment) { getComments().add(comment);
	 * comment.setCommentBean(this);
	 * 
	 * return comment; }
	 * 
	 * public Comment removeComment(Comment comment) {
	 * getComments().remove(comment); comment.setCommentBean(null);
	 * 
	 * return comment; }
	 */

	@JsonIgnore
	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	@JsonIgnore
	public Version getVersion() {
		return this.version;
	}

	public void setVersion(Version version) {
		this.version = version;
	}

	public Integer getX() {
		return x;
	}

	public void setX(Integer x) {
		this.x = x;
	}

	public Integer getY() {
		return y;
	}

	public void setY(Integer y) {
		this.y = y;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public boolean isDraggable() {
		return draggable;
	}

	public void setDraggable(boolean draggable) {
		this.draggable = draggable;
	}

	public String getStroke() {
		return stroke;
	}

	public void setStroke(String stroke) {
		this.stroke = stroke;
	}

	public boolean isSolved() {
		return solved;
	}

	public void setSolved(boolean solved) {
		this.solved = solved;
	}
	
	public List<ReplyComment> getReplyComments() {
		return this.replyComments;
	}

	public void setReplyComments(List<ReplyComment> replyComments) {
		this.replyComments = replyComments;
	}

}