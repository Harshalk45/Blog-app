package com.codewithharshal.blog.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codewithharshal.blog.payloads.ApiResponse;
import com.codewithharshal.blog.payloads.CategoryDto;
import com.codewithharshal.blog.services.CategoryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/categorys")
public class Categorycontroller {
     
	@Autowired
	private CategoryService categoryService ;

	//create
	@PostMapping("/")
	public ResponseEntity<CategoryDto>createCategory(@Valid @RequestBody CategoryDto categoryDto)
	{
		CategoryDto createCategory=this.categoryService.createCategory(categoryDto);
		return new ResponseEntity<CategoryDto> (createCategory,HttpStatus.CREATED);
		
	}
	
	//update
	@PutMapping("/{catId}")
	public ResponseEntity<CategoryDto>updateCategory(@Valid @RequestBody CategoryDto categoryId,@PathVariable Integer catId)
	{
		CategoryDto updatedCategory=this.categoryService.updateCategory(categoryId,catId);
		return new ResponseEntity<CategoryDto> (updatedCategory,HttpStatus.OK);
		
	}
	
	//delete
	@DeleteMapping("/{catId}")
	public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer catId)
	{
		this.categoryService.deleteCategory(catId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Category deleted successfully",true),HttpStatus.OK);
		
	}
	
	//get by id
	@GetMapping("/{catId}")
	public ResponseEntity<CategoryDto>getCategory(@PathVariable Integer catId)
	{
		CategoryDto categoryDto=this.categoryService.getCategory(catId);
		return new ResponseEntity<CategoryDto> (categoryDto,HttpStatus.OK);
		
	}
	
	//get all
	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>>getCategorys()
	{
		List<CategoryDto> categorys=this.categoryService.getAllCategorys();
		return ResponseEntity.ok(categorys);
		
	}
	
}
