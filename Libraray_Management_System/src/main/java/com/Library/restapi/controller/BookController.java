package com.Library.restapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.Library.restapi.entity.Book;
import com.Library.restapi.entity.User;
import com.Library.restapi.repository.Bookrepository;
import com.Library.restapi.repository.userrepository;

@RestController
@RequestMapping("/Book")
public class BookController {
    
    @Autowired
    Bookrepository repo;
    
    @Autowired
    userrepository urepo;

    @GetMapping("/Books")
    public List<Book> getAllBooks() {
        return repo.findAll();
    }

    @GetMapping("/Books/{id}")
    public Book getBook(@PathVariable int id) {
        Optional<Book> bookOptional = repo.findById(id);
        return bookOptional.orElse(null);
    }

    @PostMapping("/Books/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Book createBook(@RequestBody Book book) {
        return repo.save(book);
    }

    @DeleteMapping("/Books/delete/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void removeBook(@PathVariable int id) {
        Optional<Book> bookOptional = repo.findById(id);
        bookOptional.ifPresent(book -> repo.delete(book));
    }

    @PutMapping("/Books/borrow/{bookId}/{userId}")
    public Book borrowBook(@PathVariable int bookId, @PathVariable int userId) {
        Optional<Book> bookOptional = repo.findById(bookId);
        Optional<User> userOptional = urepo.findById(userId);

        if (bookOptional.isPresent() && userOptional.isPresent() && !bookOptional.get().isBorrowed()) {
            Book book = bookOptional.get();
            book.setBorrowedBy(userOptional.get());
            book.setBorrowed(true);
            return repo.save(book);
        }
        return null;
    }

    @PutMapping("Books/return/{bookId}")
    public Book returnBook(@PathVariable int bookId) {
        Optional<Book> bookOptional = repo.findById(bookId);

        if (bookOptional.isPresent() && bookOptional.get().isBorrowed()) {
            Book book = bookOptional.get();
            book.setBorrowedBy(null);
            book.setBorrowed(false);
            return repo.save(book);
        }
        return null;
    }
}
