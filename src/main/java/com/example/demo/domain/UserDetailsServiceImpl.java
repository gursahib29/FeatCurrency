package com.example.demo.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.demo.repository.UserRepository;
public class UserDetailsServiceImpl implements UserDetailsService {
	
	private UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		ApplicationUser User = userRepository.findByUsername(username);
        if (User == null) {
            throw new UsernameNotFoundException(username);
        }
        return new User(User.getUsername(), User.getPassword(), new ArrayList());
	}
}
