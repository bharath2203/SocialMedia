package com.bharath.socialmedia.core.dao;

import com.bharath.socialmedia.core.models.User;

import java.util.List;

public interface UserDao {

    /**
     * Fetches the user object by userId
     * @param userId
     * @return User object
     */
    public User findByUserId(String userId);

    /**
     * Creates a User in database, returns the userId.
     * @param user
     * @return Created User ID
     */
    public String createUser(User user);

    /**
     * Returns all the users.
     * @return All users.
     */
    public List<User> findAllUsers();

}
