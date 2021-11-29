package com.biblioteca.service.api;

import com.biblioteca.entity.User;

import com.biblioteca.utils.GenericServiceAPI;

public interface UserServiceAPI extends GenericServiceAPI<User,Integer> {
    public User getByEmail(String email);
}
