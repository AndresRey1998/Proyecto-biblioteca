package com.biblioteca.repository;

import com.biblioteca.entity.CategoryBook;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryBookRepository extends CrudRepository<CategoryBook,Integer> {
}
