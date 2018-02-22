package com.example.repository;

import com.example.model.Author;
import org.springframework.data.repository.CrudRepository;

/**
 * author repository interface. Provides basic CRUD operations
 */
public interface AuthorRepository extends CrudRepository<Author, Long> {
}
