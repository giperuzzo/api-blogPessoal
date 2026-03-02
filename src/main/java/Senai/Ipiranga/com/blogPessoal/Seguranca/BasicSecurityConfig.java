package Senai.Ipiranga.com.blogPessoal.Seguranca;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class BasicSecurityConfig {
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuthenticationManager autheticationManager(
			HttpSecurity http,
			PasswordEncoder passwordEncoder,
			UserDetailsService userDetailsService) throws Exception{
		AuthenticationManagerBuilder builder =
				http.getSharedObject(AuthenticationManagerBuilder.class);
		builder.userDetailsService(userDetailsService)
		.passwordEncoder(passwordEncoder);
		return builder.build();
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http
			.csrf(csrf -> csrf.disable())
			.cors(cors -> {})
			.sessionManagement(session -> 
				session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
			.authorizeHttpRequests(auth -> auth
			.requestMatchers("/usuario/logar").permitAll()
			.requestMatchers("/usuario/cadastrar").permitAll()
			.anyRequest().authenticated()
		);
			http.httpBasic(basic -> {});
		return http.build();
		}
		
		
	}

