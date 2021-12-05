package com.biblioteca.service.impl;

import com.biblioteca.entity.Book2;
import com.biblioteca.repository.Book2Repository;
import com.biblioteca.service.api.Book2ServiceAPI;;
import com.biblioteca.utils.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class Book2ServiceIMPL extends GenericServiceImpl<Book2,Integer> implements Book2ServiceAPI {
    @Autowired
    private Book2Repository BookDaoAPI;

    @Override
    public CrudRepository<Book2, Integer> getDao() {return BookDaoAPI;}
}
