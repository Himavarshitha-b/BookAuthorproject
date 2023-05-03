package com.example.securityconfig;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import com.example.service.UserUserDetailsService;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
	// authentication
	@Bean
	public UserDetailsService userDetailsService() {
//		UserDetails user = User.withUsername("Shiva").password(encoder.encode("Jayanth")).roles().build();
//		return new InMemoryUserDetailsManager(user)
		return new UserUserDetailsService();
	}
	
	// autherization
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		return httpSecurity.csrf().disable().authorizeHttpRequests()
				.requestMatchers("/bookAuthors/getAllBookAuthors","/bookAuthors/addBookAuthor","/bookAuthors/getBookAuthor/{id}","/bookAuthors/updateBookAuthors/{id}","/bookAuthors/deleteBookAuthors/{id}","/Register","/Login")
				.permitAll().and()
				.authorizeHttpRequests().requestMatchers("/**").authenticated().and().formLogin().and().build();
	}
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
 public AuthenticationProvider authenticationProvider() {
	 
	DaoAuthenticationProvider authenticationProvider =new DaoAuthenticationProvider();
	authenticationProvider.setUserDetailsService(userDetailsService());
    authenticationProvider.setPasswordEncoder(passwordEncoder());
    return authenticationProvider;
	 
 }
}
	 
	 
	 
	 
	 
	 
	 
 
