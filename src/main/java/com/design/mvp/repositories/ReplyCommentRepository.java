package com.design.mvp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.design.mvp.entities.ReplyComment;

public interface ReplyCommentRepository extends JpaRepository<ReplyComment, Long>{

}
