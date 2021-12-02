package com.biblioteca.service.impl;

import com.biblioteca.entity.Editorial;
import com.biblioteca.repository.EditorialRepository;
import com.biblioteca.service.api.EditorialServiceAPI;
import com.biblioteca.utils.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class EditorialServiceIMPL extends GenericServiceImpl<Editorial,Integer> implements EditorialServiceAPI {
    @Autowired
    private EditorialRepository EditorialDaoAPI;

    @Override
    public CrudRepository<Editorial, Integer> getDao() {return EditorialDaoAPI;}
}