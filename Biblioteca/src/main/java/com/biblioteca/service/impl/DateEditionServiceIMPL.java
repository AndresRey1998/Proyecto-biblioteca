package com.biblioteca.service.impl;

import com.biblioteca.entity.DateEdition;
import com.biblioteca.repository.DateEditionRepository;
import com.biblioteca.service.api.DateEditionServiceAPI;
import com.biblioteca.utils.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class DateEditionServiceIMPL extends GenericServiceImpl<DateEdition,Integer> implements DateEditionServiceAPI {
    @Autowired
    private DateEditionRepository DateEditionDaoAPI;

    @Override
    public CrudRepository<DateEdition, Integer> getDao() {return DateEditionDaoAPI;}
}