package com.codewithharshal.blog.services;

import java.util.List;

import com.codewithharshal.blog.entities.User;
import com.codewithharshal.blog.payloads.UserDto;

public interface UserService {
  
	User createUser(User user);
	
	UserDto updateUser(UserDto user,Integer userId);
	
	UserDto getUserById(Integer userId);
	
	List<UserDto> getAllUsers();
	
	void deleteUser(Integer userId);

	UserDto createUser(UserDto userDto);
	
}
