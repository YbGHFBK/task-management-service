package com.f1zwy.task_service;

import com.f1zwy.task_service.model.User;
import com.f1zwy.task_service.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserRepositoryTest {

	@Autowired
	private UserRepository userRepository;

	@Test
	public void testSaveUser() {
		User user = new User();
		user.setUsername("testUser");
		user.setEmail("test@example.com");
		user.setPassword("encodedPassword");

		User savedUser = userRepository.save(user);
		assertNotNull(savedUser.getId());
	}
}
