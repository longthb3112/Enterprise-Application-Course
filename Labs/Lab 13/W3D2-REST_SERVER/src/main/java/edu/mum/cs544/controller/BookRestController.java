package edu.mum.cs544.controller;

import edu.mum.cs544.domain.Book;
import edu.mum.cs544.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookRestController {
    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public List<Book> getAll() {
        return bookService.getALl();
    }

    @GetMapping("/books/{id}")
    public Book get(@PathVariable int id) {
        Book b =  bookService.get(id);
        b.getAuthor();
        return b;
    }

    @PostMapping("/books")
    public RedirectView add(@RequestBody Book book) {
        bookService.create(book);
        return new RedirectView("/books/" + book.getId());
    }

    @PutMapping("/books/{id}")
    public void update(@RequestBody Book book) {
        bookService.update(book);
    }

    @DeleteMapping("/books/{id}")
    public void delete(@PathVariable int id) {
        bookService.delete(id);
    }

}
