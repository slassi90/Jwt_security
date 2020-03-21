package org.sid.Dao;

import org.sid.Entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<AppUser, Long> {
	public AppUser findByUsername(String username);

}
