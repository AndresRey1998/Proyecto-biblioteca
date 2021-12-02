package com.biblioteca.repository;

import com.biblioteca.entity.EditionBook;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EditionBookRepository extends CrudRepository<EditionBook,Integer> {
}
