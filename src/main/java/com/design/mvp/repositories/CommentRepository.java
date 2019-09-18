package com.design.mvp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.design.mvp.entities.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long>{

}
