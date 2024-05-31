package com.codewithharshal.blog.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codewithharshal.blog.entities.Comment;
import com.codewithharshal.blog.entities.Post;
import com.codewithharshal.blog.exceptions.ResourceNotFoundException;
import com.codewithharshal.blog.payloads.CommentDto;
import com.codewithharshal.blog.repositories.CommentRepo;
import com.codewithharshal.blog.repositories.PostRepo;
import com.codewithharshal.blog.services.CommentService;


@Service
public class CommentServiceImpl implements CommentService {
     
	@Autowired
	private PostRepo postrRepo;
	
	@Autowired
	private CommentRepo commentRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public CommentDto createComment(CommentDto commentDto, Integer postId){
		
	    Post post = this.postrRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post", "post id", postId));		
	    
	    Comment comment = this.modelMapper.map(commentDto, Comment.class);
	    
	    Comment savedComment = this.commentRepo.save(comment);
	    
	    return this.modelMapper.map(savedComment,CommentDto.class);
	}

	@Override
	public void deletecomment(Integer commentId) {
		
		Comment com = this.commentRepo.findById(commentId).orElseThrow(()-> new ResourceNotFoundException("Comment", "CommentId", commentId));
        this.commentRepo.delete(com);


	}

}
