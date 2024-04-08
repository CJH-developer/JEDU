package com.geomin.project.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import com.geomin.project.security.CustomLoginFailureHandler;

@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity (prePostEnabled = true)
public class SecurityConfig {

	@Autowired
	private MyUserDetailsService myUserDetailsService;

    @Bean
    BCryptPasswordEncoder encode() {
		return new BCryptPasswordEncoder();
	}


    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf(csrf -> csrf.disable());

//		http.authorizeRequests( (a) -> a.antMatchers("/user/login", "/css/**", "/img/**",  "/js/**").permitAll()
//										.anyRequest().authenticated());
//				.antMatchers("/user/**").hasAnyRole("USER","ADMIN","TESTER")
//				.antMatchers("/admin/**").hasRole("ADMIN")
//				.anyRequest().permitAll());
        
        http
                .formLogin(login -> login
                        .loginPage("/member/login")
                        .loginProcessingUrl("/member/loginForm")
                        .usernameParameter("user_id")
                        .passwordParameter("user_pw")
                        .failureHandler(customLoginFailureHandler())
                        .successHandler(customLoginSuccessHandler()))
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/main"));

		//.successHandler(customLoginSuccessHandler());


		
		return http.build();
	}


    @Bean
    CustomLoginFailureHandler customLoginFailureHandler() {
		
		CustomLoginFailureHandler custom = new CustomLoginFailureHandler();
		custom.setRedirectURL("/member/login?err=true");
		
		return custom;
	}

    @Bean
    CustomLoginSuccessHandler customLoginSuccessHandler() {
		
		CustomLoginSuccessHandler custom = new CustomLoginSuccessHandler();
		custom.setRedirectURL("");
		
        return custom;
    }
	
}
