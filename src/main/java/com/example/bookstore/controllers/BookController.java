package com.example.bookstore.controllers;

import com.example.bookstore.models.Book;
import com.example.bookstore.services.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    @Operation(summary = "return all books")
    @ApiResponse(responseCode = "200", description = "if all books successfully returned")
    @GetMapping
    public ResponseEntity<Collection<Book>> getAllBooks () {
        Collection<Book> books = bookService.getAll();
        if (books.isEmpty()) {
            ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(books);
    }

    @Operation(summary = "return book by id")
    @ApiResponse(responseCode = "200", description = "if book return by id successfully")
    @ApiResponse(responseCode = "404", description = "if book not found by id")
    @GetMapping("/{id}")
    public ResponseEntity<Book> getById (@PathVariable("id") UUID id) {
        Book book = bookService.getById(id);
        return ResponseEntity.ok(book);
    }

    @Operation(summary = "save book to store")
    @ApiResponse(responseCode = "200", description = "if book will saved successfully")
    @PostMapping()
    public ResponseEntity<Book> save (@RequestBody Book book) {
        Book savedBook = bookService.save(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBook);
    }

    @ApiResponse(responseCode = "200", description = "if book will updated successfully")
    @ApiResponse(responseCode = "404", description = "book not found by id and not updated")
    @Operation(summary = "update book by id")
    @PutMapping("/{id}")
    public ResponseEntity<Book> update (@PathVariable("id") UUID id, @RequestBody Book book) {
        Book updatedBook = bookService.update(id, book);
        return ResponseEntity.status(HttpStatus.OK).body(updatedBook);
    }

    @ApiResponse(responseCode = "200", description = "book was successfully deleted")
    @ApiResponse(responseCode = "200", description = "book not found by id and not deleted")
    @Operation(summary = "delete book by id")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete (@PathVariable("id") UUID id) {
        Book book = bookService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Book with name '" + book.getTitle() + "' was deleted");
    }
}
