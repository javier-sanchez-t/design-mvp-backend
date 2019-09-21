package com.design.mvp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.design.mvp.entities.Comment;
import com.design.mvp.services.CommentService;

@RestController
@RequestMapping("/comments")
public class CommentController {
	
	@Autowired
	CommentService commentService;
	
	@PostMapping
	Comment saveComment(@RequestBody Comment newComment) {
		return commentService.saveComment(newComment);
	}
	
}
