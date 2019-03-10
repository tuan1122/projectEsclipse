package com.dao;

import com.entity.Users;

public interface IUserDao {
	Users getActiveUser(String userName);
}
