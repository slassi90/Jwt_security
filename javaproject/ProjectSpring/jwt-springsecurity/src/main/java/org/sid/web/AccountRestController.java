package org.sid.web;

import org.sid.Entities.AppUser;
import org.sid.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountRestController {
	@Autowired
	private AccountService accountservice;
	
	@PostMapping("/registre")
	public AppUser registre(@RequestBody AppUser user ) {
		return accountservice.saveuser(user);
		
	}

}
