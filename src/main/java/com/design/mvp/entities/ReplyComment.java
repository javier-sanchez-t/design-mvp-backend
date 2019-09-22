package com.design.mvp.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * The persistent class for the reply_comments database table.
 * 
 */
@Entity
@Table(name="reply_comments")
@NamedQuery(name="ReplyComment.findAll", query="SELECT r FROM ReplyComment r")
public class ReplyComment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_reply_comment")
	private Long idReplyComment;

	private String comment;

	//bi-directional many-to-one association to Comment
	@ManyToOne
	@JoinColumn(name="id_comment")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Comment commentBean;

	public ReplyComment() {
	}

	public Long getIdReplyComment() {
		return this.idReplyComment;
	}

	public void setIdReplyComment(Long idReplyComment) {
		this.idReplyComment = idReplyComment;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@JsonIgnore
	public Comment getCommentBean() {
		return this.commentBean;
	}

	public void setCommentBean(Comment commentBean) {
		this.commentBean = commentBean;
	}

}