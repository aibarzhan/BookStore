package com.example.bookstore.services.impl;

import com.example.bookstore.exceptions.BookNotFoundException;
import com.example.bookstore.models.Book;
import com.example.bookstore.repositories.BookRepository;
import com.example.bookstore.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository repository;

    @Override
    public Collection<Book> getAll () {
        return repository.getAll();
    }

    @Override
    public Book getById (UUID id) {
        Book book = repository.getById(id);
        if (book == null) {
            throw new BookNotFoundException("Book not found by id " + id);
        }
        return book;
    }

    @Override
    public Book save (Book book) {
        return repository.save(book);
    }

    @Override
    public Book delete (UUID id) {
        Book book = repository.delete(id);
        if (book == null) {
            throw new BookNotFoundException("Book not found by id " + id + " and not removed");
        }
        return book;
    }

    @Override
    public Book update (UUID id, Book updatedBook) {
        Book book = repository.getById(id);
        if (book != null) {
            book.setTitle(updatedBook.getTitle());
            book.setAuthor(updatedBook.getAuthor());
            book.setPrice(updatedBook.getPrice());

            repository.save(book);
        } else {
            throw new BookNotFoundException("Book not found by id " + id + " and not updated");
        }
        return book;
    }
}
