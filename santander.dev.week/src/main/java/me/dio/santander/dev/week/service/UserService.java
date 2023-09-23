package me.dio.santander.dev.week.service;

import me.dio.santander.dev.week.model.User;

public interface UserService{
    User findById(Long id);
    User create(User user);
}
