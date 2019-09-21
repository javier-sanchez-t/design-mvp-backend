package com.design.mvp.services;

import org.springframework.stereotype.Service;
import com.design.mvp.entities.Comment;

public interface CommentService {
	Comment saveComment(Comment newComment);
}
