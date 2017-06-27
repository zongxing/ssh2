package com.mashen.dao;

import java.util.List;

import com.mashen.model.User;

public interface IUserDao {
	public void add(User user);
	public List<User> getUserList();
}
