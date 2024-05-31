package com.codewithharshal.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithharshal.blog.entities.Comment;

public interface CommentRepo extends JpaRepository<Comment, Integer> {

}
