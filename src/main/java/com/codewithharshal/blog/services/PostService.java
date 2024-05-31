package com.codewithharshal.blog.services;

import java.util.List;

import com.codewithharshal.blog.entities.Post;
import com.codewithharshal.blog.payloads.PostDto;
import com.codewithharshal.blog.payloads.PostResponse;


public interface PostService {
	//create
	PostDto createPost(PostDto postDto,Integer userId,Integer categoryId);
	
	//update
	PostDto updatePost(PostDto postDto,Integer userId,Integer categoryId);
	
	//delete
	void deletePost(Integer postId);
	
	//get all posts
	PostResponse getAllPost(Integer pageNumber, Integer pageSize,String sortBy,String sortDir);
	
	//get single post
	PostDto getPostById(Integer postId);
	
	
	//get all by category
	List<PostDto> getPostByCategory(Integer categoryId);
	
	//get all by user
	List<PostDto> getPostByUser(Integer userId);
	
	//search post
	List<PostDto> searchPosts(String keyword);
	
	

}
