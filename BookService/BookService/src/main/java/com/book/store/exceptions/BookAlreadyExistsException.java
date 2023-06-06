package com.book.store.exceptions;

public class BookAlreadyExistsException extends RuntimeException {
	public BookAlreadyExistsException(String msg) {
		super(msg);
	}
}
