package com.example.bootstrap;

import com.example.model.Author;
import com.example.model.Book;
import com.example.model.Publisher;
import com.example.repository.AuthorRepository;
import com.example.repository.BookRepository;
import com.example.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Primes the DB
 */
@Component
@Profile("dev")
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    /**
     * Autowires the Repository interface for the database
     *
     * @param authorRepository    the author repo interface
     * @param bookRepository      the book repo interface
     * @param publisherRepository the publisher repo interface
     */
    @Autowired
    private DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initData();
    }

    private void initData() {
        // Eric
        Author eric = new Author("Eric", "Evans");
        Publisher pub1 = new Publisher("Harper Collins", "Naples Florida 34105");
        Book ddd = new Book("Domain Driven Design", "1234", pub1);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        publisherRepository.save(pub1);
        bookRepository.save(ddd);

        // Rod
        Author rod = new Author("Rod", "Johnson");
        Publisher pub2 = new Publisher("Worx", "Fort Myers Florida");
        Book aaa = new Book("J2EE Development without EJB", "123456", pub2);
        rod.getBooks().add(aaa);
        aaa.getAuthors().add(rod);

        authorRepository.save(rod);
        publisherRepository.save(pub2);
        bookRepository.save(aaa);

    }
}
