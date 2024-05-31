package com.codewithharshal.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithharshal.blog.entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer>{
    
	
}
