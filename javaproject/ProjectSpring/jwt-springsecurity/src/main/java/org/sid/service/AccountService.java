package org.sid.service;

import org.sid.Entities.AppRole;
import org.sid.Entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountService  {
	public AppUser saveuser(AppUser user);
	public AppRole saverole(AppRole role);
	public void addroleToUse (String username,String roleName);
	public AppUser findUserByUserNamae(String username);
	

}
