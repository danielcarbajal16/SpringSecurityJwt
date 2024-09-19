package com.example.SpringSecurityJwt;

import com.example.SpringSecurityJwt.models.ERole;
import com.example.SpringSecurityJwt.models.RoleEntity;
import com.example.SpringSecurityJwt.models.UserEntity;
import com.example.SpringSecurityJwt.repositories.UserRepository;
import org.hibernate.usertype.EnhancedUserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

@SpringBootApplication
public class SpringSecurityJwtApplication {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityJwtApplication.class, args);
	}

	@Bean
	CommandLineRunner init() {
		return args -> {
			UserEntity userEntity = UserEntity.builder()
				.username("eduardo")
				.email("eduardo@gmail.com")
				.password(passwordEncoder.encode("1234"))
				.roles(Set.of(RoleEntity.builder().name(ERole.USER).build()))
				.build();

			UserEntity daniel = UserEntity.builder()
				.username("daniel")
				.email("daniel@gmail.com")
				.password(passwordEncoder.encode("1234"))
				.roles(Set.of(RoleEntity.builder().name(ERole.ADMIN).build()))
				.build();

			UserEntity robert = UserEntity.builder()
				.username("robert")
				.email("robert@gmail.com")
				.password(passwordEncoder.encode("1234"))
				.roles(Set.of(RoleEntity.builder().name(ERole.INVITED).build()))
				.build();

			userRepository.save(userEntity);
			userRepository.save(daniel);
			userRepository.save(robert);
		};
	}
}
