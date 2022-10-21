package com.bharath.socialmedia.core.services;

import com.bharath.socialmedia.core.dao.UserDao;
import com.bharath.socialmedia.core.db.memory.UserDB;
import com.bharath.socialmedia.core.models.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserDao userDao;

    public UserService(UserDB userDB) {
        this.userDao = userDB;
    }

    public User fetchUserById(String userId) {
        return userDao.findByUserId(userId);
    }

    public String createUser(User user) {
        return userDao.createUser(user);
    }

    public List<User> fetchAllUsers() {
        return userDao.findAllUsers();
    }

}
