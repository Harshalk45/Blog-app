package com.codewithharshal.blog.payloads;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {
     
	
	private Integer categoryId;
	
	@NotBlank
	@Size(max=4,message="Min Size category Title is 4")
	private String categoryTitle;
	
	@NotBlank
	@Size(max=10,message="Max Size category Title is 10")
	private String categoryDescription;
		
}	
