package com.springboot.TodoApp20;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.web.SecurityFilterChain;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

//	//security configs
//	@Configuration
//	public class securityConfig{
//
//		@Bean
//		public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
////			http.csrf().disable()
////			.authorizeHttpRequests()
////			.requestMatchers("/")
////			.permitAll()
////			.and()
////			.formLogin()
////			.loginPage("/login");
//			http.formLogin(form-> form.loginPage("/login"));
//			return http.build();
//			
//		}
//}
}