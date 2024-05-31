package com.codewithharshal.blog.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codewithharshal.blog.exceptions.*;
import com.codewithharshal.blog.entities.User;
import com.codewithharshal.blog.payloads.UserDto;
import com.codewithharshal.blog.repositories.UserRepo;
import com.codewithharshal.blog.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	
     @Autowired
	private UserRepo userRepo;
     
     @Autowired
     private ModelMapper modelMapper;
	
	
	@Override
	public UserDto createUser(UserDto userDto)
	{
		User user = this.dtoUser(userDto);  
		User savedUser = this.userRepo.save(user);
		return this.userToDto(savedUser);
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());
		User updateUser = this.userRepo.save(user);
		UserDto userDto1=this.userToDto(updateUser);
		
		return userDto1;
	}

	@Override
	public UserDto getUserById(Integer userId) {
		
		User user=this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","Id",userId));
		return this.userToDto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {
	    
		List<User> users = this.userRepo.findAll();
	List<UserDto> userDtos =  users.stream().map(user->this.userToDto(user)).collect(Collectors.toList());
		
		return  userDtos ;
	}

	@Override
	public void deleteUser(Integer userId) {
		
		User user = this.userRepo.findById(userId)
		.orElseThrow(()-> new ResourceNotFoundException("User","Id",userId));
      
		this.userRepo.delete(user);
	}
    public  User dtoUser(UserDto userDto){
    	User user = this.modelMapper.map(userDto, User.class);
//    {
//    	User user= new User();
//    	user.setId(userDto.getId());
//    	user.setName(userDto.getName());
//    	user.setEmail(userDto.getEmail());
//    	user.setAbout(userDto.getAbout());
//    	user.setPassword(userDto.getPassword());
		return user;
    	
    }
    
    public UserDto userToDto(User user){
    	UserDto userDto = this.modelMapper.map(user, UserDto.class);
//    	UserDto userDto = new UserDto();
//    	user.setId(user.getId());
//    	user.setName(user.getName());
//    	user.setEmail(user.getEmail());
//    	user.setAbout(user.getAbout());
//    	user.setPassword(user.getPassword());
		return userDto;
    }

	@Override
	public User createUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}
}
