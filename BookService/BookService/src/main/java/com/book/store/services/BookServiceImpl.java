package com.book.store.services;

import com.book.store.dao.BookDAO;
import com.book.store.dto.CreateBookDTO;
import com.book.store.dto.UpdateBookDTO;
import com.book.store.dto.UserDTO;
import com.book.store.enums.BookEditStatusEnum;
import com.book.store.enums.BookStatusEnum;
import com.book.store.exceptions.BookAlreadyExistsException;
import com.book.store.exceptions.BookLimitExceededException;
import com.book.store.exceptions.ResourceNotFoundException;
import com.book.store.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;

@Service

public class BookServiceImpl implements BookService{

    @Autowired
    private BookDAO bookDAO;
    
    
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<Book> allBooks() {
        return bookDAO.findAll();
    }

    @Override
    public Book getBook(Long bookId) {
        return bookDAO.findById(bookId).orElseThrow(()-> new ResourceNotFoundException("Book not found"));
    }

    @Override
    public void deleteBook(Long bookId) {
        bookDAO.deleteById(bookId);
    }


    @Override
    public List<Book> finishedBooks() {
        return bookDAO.findByEditStatus(BookEditStatusEnum.COMPLETED);
    }

    @Override
    public List<Book> publishedBooks() {
        return bookDAO.findByBookStatus(BookStatusEnum.PUBLISHED);
    }

    @Override
    public List<Book> myBooks(Long userId) {
        return bookDAO.findByUser(userId);
    }

    @Override
    public Book createBook(CreateBookDTO r) {
    	 UserDTO user= restTemplate.getForObject("http://USER-SERVICE/api/user/author-details/{userId}", UserDTO.class, r.getUserId());
        Book book = new Book();
        long currentWorkingCount = bookDAO.countByUserAndEditStatus(r.getUserId(), BookEditStatusEnum.WORKING);
        
        if(bookDAO.findByTitle(r.getTitle())!=null) {
        	throw new BookAlreadyExistsException("Book already exists");
        }
        
        if(currentWorkingCount >= 3 ) throw new BookLimitExceededException();
        

       book.setUser(user.getId());
        book.setTitle(r.getTitle());
        book.setPrice(r.getPrice());
        book.setPages(r.getPages());
        book.setDescription(r.getDescription());
        book.setContent(r.getContent());
        book.setBookStatus(BookStatusEnum.PENDING);
        book.setEditStatus(BookEditStatusEnum.WORKING);
        book.setCreatedAt(LocalDateTime.now());
        bookDAO.save(book);
        return book;
    }

    @Override
    public Book updateBook(UpdateBookDTO r) {
        Book book = bookDAO.findById(r.getBookId()).orElseThrow(() -> new ResourceNotFoundException("Book not found."));
        book.setContent(r.getContent());
        book.setPages(r.getPages());
        book.setEditStatus(r.getEditStatus());
        bookDAO.save(book);
        return book;
    }


}
