package com.eduinsuncheon.blog.repository;

import com.eduinsuncheon.blog.model.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReplyRepository extends JpaRepository<Reply, Integer> {
}
