package com.biblioteca.service.impl;

import com.biblioteca.entity.Book;
import com.biblioteca.repository.BookRepository;
import com.biblioteca.service.api.BookServiceAPI;
import com.biblioteca.utils.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class BookServiceIMPL extends GenericServiceImpl<Book,Integer> implements BookServiceAPI {
    @Autowired
    private BookRepository BookDaoAPI;

    @Override
    public CrudRepository<Book, Integer> getDao() {return BookDaoAPI;}
}
