package com.shabbir.api.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shabbir.api.user.dto.UserDTO;
import com.shabbir.api.user.exception.UserNotFoundException;
import com.shabbir.api.user.model.User;
import com.shabbir.api.user.repositry.UserRepositry;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepositry repositry;

	@Override
	public User saveUser(UserDTO user1) {
		User user = new User();
		user.setEmailId(user1.getEmailId());
		user.setFirstName(user1.getFirstName());
		user.setLastName(user1.getLastName());
		user.setPhoneNumber(user1.getPhoneNumber());
		user.setGender(user1.getGender());
		User save = this.repositry.save(user);
		return save;
	}

	@Override
	public List<User> getAllUser() {
		List<User> list = this.repositry.findAll();
		return list;
	}

	@Override
	public User findByUserId(String id) {

		return this.repositry.findById(id).orElseThrow(() -> new UserNotFoundException("User not exit's with id" + id));
	}

	@Override
	public void deleteUserById(String id) {
		User user = this.repositry.findById(id)
				.orElseThrow(() -> new UserNotFoundException("User not exit's with id" + id));
		this.repositry.delete(user);
	}

	@Override
	public User updateUser(String id, User user) {
		User user1 = this.repositry.findById(id)
				.orElseThrow(() -> new UserNotFoundException("User not exit's with id" + id));
		if (user.getEmailId() != null) {
			user1.setEmailId(user.getEmailId());
		}if (user.getFirstName() != null) {
			user1.setFirstName(user.getFirstName());
		}if (user.getGender() != null) {
			user1.setGender(user.getGender());
		}if (user.getLastName() != null) {
			user1.setLastName(user.getLastName());
		}if (user.getPhoneNumber() != null) {
			user1.setPhoneNumber(user.getPhoneNumber());
		}User save = this.repositry.save(user1);
		return save;
	}
}