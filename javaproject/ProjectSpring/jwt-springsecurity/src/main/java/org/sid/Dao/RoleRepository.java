package org.sid.Dao;

import org.sid.Entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<AppRole, Long> {
public AppRole findByRoleName(String rolename);

}
