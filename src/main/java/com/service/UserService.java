package com.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dao.IUserDao;
import com.entity.Users;

@Service
public class UserService implements UserDetailsService {
	@Autowired
	private IUserDao userInfoDAO;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users activeUserInfo = userInfoDAO.getActiveUser(username);
		GrantedAuthority authority = new SimpleGrantedAuthority(activeUserInfo.getRole());
		UserDetails userDetails = (UserDetails) new User(activeUserInfo.getUsername(), activeUserInfo.getPassword(),Arrays.asList(authority));
		return userDetails;
	}
//	public boolean validateUser(String userid, String password) {
//        // in28minutes, dummy
//        return userid.equalsIgnoreCase("in28minutes")
//                && password.equalsIgnoreCase("dummy");
//    }
}
