package com.biblioteca.service.impl;

import com.biblioteca.entity.CategoryBook;
import com.biblioteca.repository.CategoryBookRepository;
import com.biblioteca.service.api.CategoryBookServiceAPI;
import com.biblioteca.utils.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryBookServiceIMPL extends GenericServiceImpl<CategoryBook,Integer> implements CategoryBookServiceAPI {
    @Autowired
    private CategoryBookRepository CategoryBookDaoAPI;

    @Override
    public CrudRepository<CategoryBook, Integer> getDao() {return CategoryBookDaoAPI;}
}
