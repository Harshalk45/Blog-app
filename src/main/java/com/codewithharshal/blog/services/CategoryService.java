package com.codewithharshal.blog.services;


import java.util.List;

import com.codewithharshal.blog.payloads.CategoryDto;

public interface CategoryService {
   
	//create
	CategoryDto createCategory(CategoryDto category);
	
	//update
	CategoryDto updateCategory(CategoryDto category,Integer categoryId);
	
	//delete
	void deleteCategory(Integer categoryId);
	
	//get
	CategoryDto getCategory(Integer categoryId);
	
	//get all
	List<CategoryDto> getAllCategorys();
	
	
}
