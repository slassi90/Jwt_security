package org.sid.service;

import java.util.List;
import java.util.Optional;

import org.sid.Dao.RoleRepository;
import org.sid.Dao.UserRepository;
import org.sid.Entities.AppRole;
import org.sid.Entities.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Transactional
@Service
public class AccountServiceImpl implements AccountService {
@Autowired
private BCryptPasswordEncoder bcryptpassswordencoder;
@Autowired
private RoleRepository rolerepository;
@Autowired
private UserRepository userrepository;
	@Override
	public AppUser saveuser(AppUser user) {
		String hashpass = bcryptpassswordencoder.encode(user.getPassword());
		user.setPassword(hashpass);
		return userrepository.save(user);
	}

	@Override
	public AppRole saverole(AppRole role) {
		// TODO Auto-generated method stub
		return rolerepository.save(role);
	}

	@Override
	public void addroleToUse(String username, String roleName) {
		AppRole role=rolerepository.findByRoleName(roleName);
		AppUser user = userrepository.findByUsername(username);
		user.getRoles().add(role);
		}

	@Override
	public AppUser findUserByUserNamae(String username) {
		
		return userrepository.findByUsername(username);
	}



}
