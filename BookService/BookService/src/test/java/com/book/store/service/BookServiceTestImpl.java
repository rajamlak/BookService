package com.book.store.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.book.store.enums.BookEditStatusEnum;
import com.book.store.enums.BookStatusEnum;
import com.book.store.models.Book;
import com.book.store.services.BookServiceImpl;

@ExtendWith({SpringExtension.class})
@DataJpaTest
@Import(BookServiceImpl.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BookServiceTestImpl {
	
	
//	@Test
//	public void testAddStudent() {
//		Book book = new Book(23,1,"TestBook",10.0,100,"The is the book for test class","this i sthe book for Test",BookEditStatusEnum.WORKING,BookStatusEnum.PENDING,);
//		Student studSaved = service.addStudent(stud);
//		Assertions.assertEquals(studSaved.getFirstName(), stud.getFirstName());
//	}

}
