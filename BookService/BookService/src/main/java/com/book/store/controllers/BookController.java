package com.book.store.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book.store.dto.BasicResponseDTO;
import com.book.store.dto.CreateBookDTO;
import com.book.store.dto.UpdateBookDTO;
import com.book.store.models.Book;
import com.book.store.services.BookService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@CrossOrigin
@RequestMapping("/api/admin")
public class BookController {
	
	@Autowired
	private BookService bookService;

	@GetMapping("/books")
    public ResponseEntity<BasicResponseDTO<List<Book>>> allBooks(){
        List<Book> books = bookService.allBooks();
        return new ResponseEntity<>(new BasicResponseDTO<>(true, "All Books", books), HttpStatus.OK);
    }
   
   
    @GetMapping("/book/{bookId}")
    public ResponseEntity<BasicResponseDTO<Book>> getBook(@PathVariable("bookId") Long bookId){
        Book book = bookService.getBook(bookId);
        return new ResponseEntity<>(new BasicResponseDTO<>(true, "Book", book), HttpStatus.OK);
    }
    
    
    public ResponseEntity<BasicResponseDTO<String>> deleteBook(@PathVariable("bookId") Long bookId){
        bookService.deleteBook(bookId);
        return new ResponseEntity<>(new BasicResponseDTO<>(true, "Book successfully deleted", null), HttpStatus.OK);
    }
    @GetMapping("/finished-books")
    public ResponseEntity<BasicResponseDTO<List<Book>>> finishedBooks(){
        List<Book> books = bookService.finishedBooks();
        return new ResponseEntity<>(new BasicResponseDTO<>(true, "Finished books", books), HttpStatus.OK);
    }
   
    @GetMapping("/published-books")
    public ResponseEntity<BasicResponseDTO<List<Book>>> publishedBooks(){
        List<Book> books = bookService.publishedBooks();
        return new ResponseEntity<>(new BasicResponseDTO<>(true, "Published books", books), HttpStatus.OK);
    }
    
    @GetMapping("/my-books/{userId}")
    public ResponseEntity<BasicResponseDTO<List<Book>>> myBooks(@PathVariable("userId") Long userId){
        List<Book> books = bookService.myBooks(userId);
        return new ResponseEntity<>(new BasicResponseDTO<>(true, "Books list", books), HttpStatus.OK);
    }


    @PostMapping("/create-book")
    public ResponseEntity<BasicResponseDTO<Book>> createBook(@RequestBody CreateBookDTO r){
        Book book = bookService.createBook(r);
        return new ResponseEntity<>(new BasicResponseDTO<>(true, "Book created", book), HttpStatus.CREATED);
    }
    @PreAuthorize("hasRole('AUTHOR')")
    @Operation(security = @SecurityRequirement(name = "bearerAuth"))
    @PutMapping("/update-book")
    public ResponseEntity<BasicResponseDTO<Book>> updateBook(@RequestBody UpdateBookDTO r){
        Book book = bookService.updateBook(r);
        return new ResponseEntity<>(new BasicResponseDTO<>(true, "Book updated", book), HttpStatus.OK);
    }
    
}
