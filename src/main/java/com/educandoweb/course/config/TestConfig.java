package com.educandoweb.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.OrderRepository;
import com.educandoweb.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public void run(String... args) throws Exception {
		User user1 = new User(null, "Usuario1", "usuario1@gmail.com", "9888888", "123456");
		User user2 = new User(null, "Usuario2", "usuario2@gmail.com", "9888888", "123456");
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), user1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), user2);
		Order o3 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), user1);
		
		userRepository.saveAll(Arrays.asList(user1, user2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
	}
}
