package com.bharath.socialmedia.core.db.memory;

import com.bharath.socialmedia.core.dao.UserDao;
import com.bharath.socialmedia.core.models.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class UserDB implements UserDao {
    private final Map<String, User> userMap;
    private Integer counter;

    public UserDB() {
        userMap = new HashMap<>();
        counter = 1;
    }

    @Override
    public User findByUserId(String userId) {
        return userMap.getOrDefault(userId, null);
    }

    @Override
    public String createUser(User user) {
        user.setUserId(counter.toString());
        userMap.put(counter.toString(), user);
        ++counter;
        return user.getUserId();
    }

    @Override
    public List<User> findAllUsers() {
        return new ArrayList<>(userMap.values());
    }
}
