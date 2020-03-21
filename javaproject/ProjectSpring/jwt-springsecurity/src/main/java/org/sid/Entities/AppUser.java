package org.sid.Entities;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class AppUser {
	@Id @GeneratedValue
private Long id;
	@Column(unique=true)
private String username;
	@JsonIgnore
private String password;
@ManyToMany(fetch=FetchType.EAGER)
private Collection<AppRole> roles = new ArrayList<>();


public AppUser(String username, String password, Collection<AppRole> roles) {
	super();
	this.username = username;
	this.password = password;
	this.roles = roles;
}




}
