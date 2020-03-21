package org.sid.sec;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecuritConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		// TODO Auto-generated method stub
		/*
	auth.inMemoryAuthentication().withUser("admin").password("12345").roles("ADMIN","USER")
		.and()
		.withUser("user").password("1234").roles("user");
		*/
		auth.userDetailsService(userDetailsService)
		//fonction de hashage ou decryptage du mot de pass
		.passwordEncoder(passwordEncoder);
		
		
		
		
		
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.formLogin();
		http.authorizeRequests().antMatchers("/login/**","/register/**").permitAll();
		http.authorizeRequests().antMatchers(HttpMethod.POST,"/addtasks/**").hasAuthority("admin");
		http.authorizeRequests().anyRequest().authenticated();

	}
}


