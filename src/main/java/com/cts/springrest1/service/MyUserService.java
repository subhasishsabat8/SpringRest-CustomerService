package com.cts.springrest1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cts.springrest1.entity.MyUserDetails;
import com.cts.springrest1.entity.User;
import com.cts.springrest1.repo.UserRepository;

@Service
public class MyUserService implements UserDetailsService {
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional userOptional = userRepository.findByUserName(username);
		
		if(userOptional.isEmpty()) {
			throw new UsernameNotFoundException("Not Found: "+username);
		}
		User user = (User) userOptional.get();
		MyUserDetails myUserDetails = new MyUserDetails(user);
		return myUserDetails;
	}

}
