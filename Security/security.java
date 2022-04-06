package com.example.demo.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User; import
org.springframework.security.core.userdetails.UserDetails; import
org.springframework.security.web.server.SecurityWebFilterChain;

@EnableWebFluxSecurity

public class security {
	@Bean
	SecurityWebFilterChain filter(ServerHttpSecurity http) {
	//http.authorizeExchange().anyExchange().authenticated().and().httpBasic().and().formLogin();
	http.authorizeExchange()
	.pathMatchers(HttpMethod.GET,"/flux/**").permitAll()
	.pathMatchers(HttpMethod.PUT,"/updateuser/{userId}/**").hasRole("ADMIN")
	.pathMatchers(HttpMethod.POST,"/create/**").hasAuthority("ROLE_ADMIN")
	.pathMatchers(HttpMethod.DELETE,"/delete/{userId}/**").hasRole("ADMIN")
	.anyExchange().authenticated().and().httpBasic().and().formLogin();
	http.csrf().disable(); return http.build(); }


	@Bean
	MapReactiveUserDetailsService userDetails()
	{
	UserDetails user = User.withDefaultPasswordEncoder()
	.username("user").password("test").roles("USER").build();

	UserDetails user1 = User.withDefaultPasswordEncoder()
	.username("hema").password("admin").roles("ADMIN").build();
	return new MapReactiveUserDetailsService(user, user1); }

	
}