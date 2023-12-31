package com.htc.register.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.htc.register.login.entity.Users;
import com.htc.register.login.repository.UsersRepo;



@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UsersRepo usersRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users users = usersRepo.findByUsersEmail(username);
		if (users == null) {
			throw new UsernameNotFoundException("User Not Found");
		}else {
		return new CustomUserDetails(users);
	}
	}
}