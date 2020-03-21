package org.sid.service;

import java.util.ArrayList;
import java.util.Collection;

import org.sid.Entities.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {
@Autowired
private AccountService accountService;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AppUser user=accountService.findUserByUserNamae(username);
		
		if(user==null)throw new UsernameNotFoundException(username);
		Collection<GrantedAuthority> authorities = new ArrayList<>();
		user.getRoles().forEach
		(r->{authorities.add(new SimpleGrantedAuthority(r.getRoleName()));
		});
		System.out.print(authorities);
	return new User(user.getUsername(),user.getPassword(),authorities);
		
	}

}
