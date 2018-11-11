package com.samonenko.spring5webapp.bootstrap;

import com.samonenko.spring5webapp.model.Author;
import com.samonenko.spring5webapp.model.Book;

public class DevBootstrap {

    private void initData() {
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "1234", "Harper Collins");
        ddd.getAuthors().add(eric);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "23455", "Worx");
        noEJB.getAuthors().add(rod);
    }

}
