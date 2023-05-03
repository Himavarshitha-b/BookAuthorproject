package com.example.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.BookAuthor;
import com.example.service.BookAuthorService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/bookAuthors")
public class BookAuthorController {

    @Autowired
    private BookAuthorService bookAuthorService;

    @PostMapping("/addBookAuthor")
    public ResponseEntity<BookAuthor> addBookAuthor(@RequestBody BookAuthor bookAuthor) {
        BookAuthor addedBookAuthor = bookAuthorService.addBookAuthor(bookAuthor);
        return new ResponseEntity<>(addedBookAuthor, HttpStatus.CREATED);
    }

    @GetMapping("/getBookAuthor/{id}")
    public ResponseEntity<BookAuthor> getBookAuthor(@PathVariable("id") Long id) {
       
		BookAuthor bookAuthor = bookAuthorService.getBookAuthor(id);
        return new ResponseEntity<>(bookAuthor, HttpStatus.OK);
    }

    @GetMapping("/getAllBookAuthors")
    public ResponseEntity<List<BookAuthor>> getAllBookAuthors() {
        List<BookAuthor> bookAuthors = bookAuthorService.getAllBookAuthors();
        return new ResponseEntity<>(bookAuthors, HttpStatus.OK);
    }

    @PutMapping("/updateBookAuthors/{id}")
    public ResponseEntity<BookAuthor> updateBookAuthor(@PathVariable("id") Long id, @RequestBody BookAuthor bookAuthor) {
        BookAuthor updatedBookAuthor = bookAuthorService.updateBookAuthor(id, bookAuthor);
        return new ResponseEntity<>(updatedBookAuthor, HttpStatus.OK);
    }

    @DeleteMapping("/deleteBookAuthors/{id}")
    public ResponseEntity<Void> deleteBookAuthor(@PathVariable("id") Long id) {
        bookAuthorService.deleteBookAuthor(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<Void> deleteAllBookAuthors() {
        bookAuthorService.deleteAllBookAuthors();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/patchBookAuthors/{id}")
    public ResponseEntity<BookAuthor> patchBookAuthor(@PathVariable("id") Long id, @RequestBody Map<Object, Object> bookAuthor) {
        BookAuthor patchedBookAuthor = bookAuthorService.patchBookAuthor(id, bookAuthor);
        return new ResponseEntity<>(patchedBookAuthor, HttpStatus.OK);
    }

}
