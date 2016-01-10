package com.coursor.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebMvcSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true, securedEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	UserDetailsService userDetailsService;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		//Mapping for logged in users
		http.authorizeRequests()
			.antMatchers("*/t/**").hasAnyRole("ADMIN","TEACHER") //Teachers
			.antMatchers("*/s/**").hasAnyRole("ADMIN","STUDENT") //Students
			.antMatchers("*/a/**").hasRole("ADMIN").and() //Admin
				.formLogin().loginPage("/login").failureUrl("/login?error")
					.usernameParameter("username")
					.passwordParameter("password")
					.and().logout().logoutSuccessUrl("/login?logout")
					.and().csrf()
					.and().exceptionHandling().accessDeniedPage("/403");
		
		
//		http.authorizeRequests()
//			.antMatchers("/login","/resources/**","/about").permitAll()
//			.antMatchers("/course/s/**").hasAnyRole("ROLE_ADMIN","ROLE_USER","ROLE_STUDENT","ROLE_TEACHER");
		
	}
	
	@Bean
	public PasswordEncoder passwordEncoder(){
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
	
}