package com.samonenko.spring5webapp.bootstrap;

import com.samonenko.spring5webapp.model.Author;
import com.samonenko.spring5webapp.model.Book;
import com.samonenko.spring5webapp.model.Publisher;
import com.samonenko.spring5webapp.repositories.AuthorRepository;
import com.samonenko.spring5webapp.repositories.BookRepository;
import com.samonenko.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository,
                        PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        Author eric = new Author("Eric", "Evans");
        Publisher publisherHC = new Publisher("Harper Collins", "Address HC");
        publisherRepository.save(publisherHC);

        Book ddd = new Book("Domain Driven Design", "1234", publisherHC);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Publisher publisherWorx = new Publisher("Worx", "Address Worx");
        publisherRepository.save(publisherWorx);
        Book noEJB = new Book("J2EE Development without EJB", "23455", publisherWorx);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
    }

}
