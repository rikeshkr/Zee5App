package com.zee.zee5app.service;

import java.util.Optional;

import com.zee.zee5app.dto.User;
import com.zee.zee5app.exceptions.UnabletoGenerateIdException;

public interface UserService {
	public User insertUser(User user) throws UnabletoGenerateIdException;
	public User updateUser(String userId, User user);
	public String deleteUser(String userId);
	public User[] getAllUsers();
	public Optional<User> getUserById(String userId);
	public String deleteUserById(String userId);
}
