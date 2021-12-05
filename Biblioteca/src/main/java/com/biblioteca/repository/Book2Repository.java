package com.biblioteca.repository;

import com.biblioteca.entity.Book2;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Book2Repository extends CrudRepository<Book2,Integer>{
}
