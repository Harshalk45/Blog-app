package com.codewithharshal.blog.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;import org.springframework.web.client.ResourceAccessException;

import com.codewithharshal.blog.entities.User;
import com.codewithharshal.blog.exceptions.ResourceNotFoundException;
import com.codewithharshal.blog.repositories.UserRepo;

public class CustomUserDetailService implements UserDetailsService {
   
	@Autowired
	private UserRepo userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = this.userRepo.findByEmail(username).orElseThrow(()->new ResourceNotFoundException("user", "email:"+ username,0));
		
		return user;
	}

}
