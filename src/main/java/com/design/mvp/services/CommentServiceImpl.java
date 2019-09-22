package com.design.mvp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.design.mvp.entities.Comment;
import com.design.mvp.entities.ReplyComment;
import com.design.mvp.repositories.CommentRepository;
import com.design.mvp.repositories.ReplyCommentRepository;

@Service
public class CommentServiceImpl implements CommentService{
	
	@Autowired
	CommentRepository commentRepository;
	
	@Autowired
	ReplyCommentRepository replyCommentRepository;

	@Override
	public Comment saveComment(Comment newComment) {
		return commentRepository.save(newComment);
	}

	@Override
	public ReplyComment saveReplyComment(ReplyComment newReplyComment) {
		return replyCommentRepository.save(newReplyComment);
	}

	@Override
	public boolean resolveComment(Long idComment) {
		if (commentRepository.resolveComment(idComment) == 1) {
			return true;
		} else {
			return false;
		}
	}

}
