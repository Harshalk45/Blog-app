package com.codewithharshal.blog.services;

import com.codewithharshal.blog.payloads.CommentDto;

public interface CommentService {
   
	 CommentDto createComment(CommentDto commentDto, Integer postId);
	 void deletecomment(Integer comment);
}
