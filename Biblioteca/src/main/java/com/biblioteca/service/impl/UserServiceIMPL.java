package com.biblioteca.service.impl;

import com.biblioteca.entity.User;
import com.biblioteca.repository.UserRepository;
import com.biblioteca.service.api.UserServiceAPI;

import com.biblioteca.utils.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceIMPL extends GenericServiceImpl<User, Integer> implements UserServiceAPI {
    @Autowired
    private UserRepository UserDaoAPI;

    @Override
    public CrudRepository<User, Integer> getDao(){
        return UserDaoAPI;
    }

    @Override
    public User getByEmail(String email) {
        return UserDaoAPI.findByEmail(email);
    }
}
