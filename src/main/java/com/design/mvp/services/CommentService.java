package com.design.mvp.services;

import org.springframework.stereotype.Service;
import com.design.mvp.entities.Comment;
import com.design.mvp.entities.ReplyComment;

public interface CommentService {
	Comment saveComment(Comment newComment);
	ReplyComment saveReplyComment(ReplyComment newReplyComment);
	boolean resolveComment(Long idComment);
}
