package com.design.mvp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.design.mvp.entities.Comment;
import com.design.mvp.repositories.CommentRepository;

@Service
public class CommentServiceImpl implements CommentService{
	
	@Autowired
	CommentRepository commentRepository;

	@Override
	public Comment saveComment(Comment newComment) {
		return commentRepository.save(newComment);
	}

}
