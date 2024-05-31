package com.codewithharshal.blog.payloads;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostDto {
    
	private Integer postid;
	private String title;
	private String content;
	private String postTitle;
	private String postContent;
	private String imageName="default.png";
	private Date addedDate;
	private CategoryDto Category;
	private UserDto User;
	private Set<CommentDto> comments = new HashSet<>();
}
