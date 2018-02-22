package com.example.repository;

import com.example.model.Book;
import org.springframework.data.repository.CrudRepository;

/**
 * Book Repository Interface. Provides basic CRUD operations
 */
public interface BookRepository extends CrudRepository<Book, Long> {
}
