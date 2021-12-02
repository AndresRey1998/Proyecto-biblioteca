package com.biblioteca.repository;

import com.biblioteca.entity.DateEdition;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DateEditionRepository extends CrudRepository<DateEdition,Integer> {
}
