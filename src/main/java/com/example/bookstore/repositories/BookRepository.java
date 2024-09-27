package com.example.bookstore.repositories;

import com.example.bookstore.models.Book;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Repository
public class BookRepository {
    private final Map<UUID, Book> books = new HashMap<>();

    public Collection<Book> getAll () {
        return books.values();
    }

    public Book getById (UUID id) {
        return books.get(id);
    }

    public Book save (Book book) {
        books.put(book.getId(), book);
        return book;
    }

    public Book delete (UUID id) {
        return books.remove(id);
    }
}
