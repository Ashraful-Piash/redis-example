package com.piashraful.redis.controller;

import com.piashraful.redis.dao.UserDao;
import com.piashraful.redis.model.Test;
import com.piashraful.redis.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserDao userDao;

    @PostMapping("create-user")
    public User createUser(@RequestBody  User user) {
        user.setUserId(UUID.randomUUID().toString());
        return userDao.save(user);
    }

    @GetMapping("/{userId}")
    public User getUser (@PathVariable("userId") String userId) {
        return userDao.get(userId);
    }

    @GetMapping("users")
    public Map<Object,Object> getAllUser( ){
        return userDao.findAll();
    }

    @DeleteMapping("/{userId}")
    public void deleteUser( @PathVariable("userId") String userId) {
        userDao.delete(userId);
    }

}
