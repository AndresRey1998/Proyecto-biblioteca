package com.biblioteca.service.impl;

import com.biblioteca.entity.Author;
import com.biblioteca.repository.AuthorRepository;
import com.biblioteca.service.api.AuthorServiceAPI;
import com.biblioteca.utils.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;


@Service
public class AuthorServiceIMPL extends GenericServiceImpl<Author,Integer> implements AuthorServiceAPI {
    @Autowired
    private AuthorRepository AuthorDaoAPI;

    @Override
    public CrudRepository<Author, Integer> getDao() {return AuthorDaoAPI;}
}
