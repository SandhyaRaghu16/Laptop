package com.onesoftproject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
@EnableWebSecurity
@Configuration
public class MyConfiguration extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("Sandhya").password("$2a$12$F7U3mUKe7XodqtNyID0A7.iwjZezlrAplxux/IHtBSfVNWQfQaHS6").roles("student")//(password:Sandhya)
		.and().withUser("Suba").password("$2a$12$/Mp4Mg4M6Jc0YlXOSi8m1uGOC/6EDSXu6vU.gInoO8X.gUULlJlTG").roles("trainer")//(password:Suba@123)
		.and().withUser("Janu").password("$2a$12$oJ7Z6KoqRBJpTHzOuqCnP.0gaVzxdShI0Bo35urv7A2mwT7CRZVpC").roles("manager");//(password:Jahnavi)
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/getManager").hasRole("manager");
		http.authorizeRequests().antMatchers("/getTrainer").hasAnyRole("manager","trainer");
		http.authorizeRequests().antMatchers("/getStudent").permitAll().and().formLogin();
	}
//	@Bean
//	public PasswordEncoder pass()
//	{
//		return NoOpPasswordEncoder.getInstance();
//	}
	
	@Bean
	public PasswordEncoder getPass()
	{
		return new BCryptPasswordEncoder(12);
	}

}
