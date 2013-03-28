package org.liferay4you.persistence;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.liferay4you.model.User;
import org.liferay4you.parent.DatabaseConectionTest;
import org.liferay4you.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:META-INF/application-context.xml")
public class UserRepositoryTest extends DatabaseConectionTest{
	
	@Autowired
	UserRepository userRepository;
	
	@Test
	public void userTests() {
		
		String testString= String.valueOf(new Date().getTime());
		
		User user = new User();
		user.setUserName("testName-"+testString);
		user.setMail(testString +"@gmail.com");
		user.setUserId(Long.valueOf(testString));
		
		user  = userRepository.save(user);
		
		assertNotEquals(0, user.getUserId());
		
		long userId = user.getUserId();
		user = null;
		user = userRepository.findOne(userId);
		
		assertNotNull(user);
		
		userRepository.delete(user);
		
	}
	
}
