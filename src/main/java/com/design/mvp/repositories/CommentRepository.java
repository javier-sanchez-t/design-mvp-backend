package com.design.mvp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.design.mvp.entities.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long>{
	@Modifying
	@Transactional
	@Query("update Comment c set c.solved = true where c.idComment = ?1")
	int resolveComment(Long idComment);
}
