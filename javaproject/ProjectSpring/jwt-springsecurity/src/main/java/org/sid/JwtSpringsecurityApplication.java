package org.sid;

import java.util.stream.Stream;

import org.sid.Entities.AppRole;
import org.sid.Entities.AppUser;
import org.sid.Entities.Task;
import org.sid.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.sid.Dao.TaskRepository;

@SpringBootApplication
public class JwtSpringsecurityApplication implements CommandLineRunner {
@Autowired
private TaskRepository taskRepository;
@Autowired
private AccountService accountservice;
	public static void main(String[] args) {
		SpringApplication.run(JwtSpringsecurityApplication.class, args);

		
			}
	@Bean
	public BCryptPasswordEncoder getbycript() {
		
		return new BCryptPasswordEncoder();
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		accountservice.saveuser(new AppUser(null,"admin","1234",null));
		accountservice.saveuser(new AppUser(null,"user","12345",null));
		accountservice.saverole(new AppRole(null,"ADMIN"));
		accountservice.saverole(new AppRole(null,"USER"));
		accountservice.addroleToUse("admin", "ADMIN");
		accountservice.addroleToUse("user", "USER");
		
		Stream.of("t1","t2","t3").forEach(t->
		{taskRepository.save(new Task(null,t));
		});
		taskRepository.findAll().forEach(t->{System.out.print(t.getTaskname());});
		
	}

}
