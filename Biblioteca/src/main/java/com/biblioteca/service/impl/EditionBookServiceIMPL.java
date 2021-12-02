package com.biblioteca.service.impl;

import com.biblioteca.entity.EditionBook;
import com.biblioteca.repository.EditionBookRepository;
import com.biblioteca.service.api.EditionBookServiceAPI;
import com.biblioteca.utils.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class EditionBookServiceIMPL extends GenericServiceImpl<EditionBook,Integer> implements EditionBookServiceAPI {
    @Autowired
    private EditionBookRepository EditionBookDaoAPI;

    @Override
    public CrudRepository<EditionBook, Integer> getDao() {return EditionBookDaoAPI;}
}
