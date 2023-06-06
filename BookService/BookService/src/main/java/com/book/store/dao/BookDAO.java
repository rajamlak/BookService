package com.book.store.dao;

import com.book.store.enums.BookEditStatusEnum;
import com.book.store.enums.BookStatusEnum;
import com.book.store.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookDAO extends JpaRepository<Book, Long> {
    long countByUserAndEditStatus(Long id, BookEditStatusEnum editStatus);
    List<Book> findByBookStatus(BookStatusEnum bookStatus);
    List<Book> findByEditStatus(BookEditStatusEnum editStatus);
    List<Book> findByUser(Long id);
	Book findByTitle(String title);
}
