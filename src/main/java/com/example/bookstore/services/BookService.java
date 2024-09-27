package com.example.bookstore.services;

import com.example.bookstore.models.Book;
import java.util.Collection;
import java.util.UUID;

public interface BookService {

    public Collection<Book> getAll ();

    public Book getById (UUID id);

    public Book save (Book book);

    public Book delete (UUID id);

    public Book update (UUID id, Book book);
}
