package com.shabbir.api.user.service;

import java.util.List;

import com.shabbir.api.user.dto.UserDTO;
import com.shabbir.api.user.model.User;

public interface UserService {

	User saveUser(UserDTO user1);

	List<User> getAllUser();

	User findByUserId(String id);

	void deleteUserById(String id);

	User updateUser(String id, User user);
}