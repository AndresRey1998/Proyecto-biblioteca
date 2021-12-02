package com.biblioteca.repository;

import com.biblioteca.entity.Editorial;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EditorialRepository extends CrudRepository<Editorial,Integer> {
}
