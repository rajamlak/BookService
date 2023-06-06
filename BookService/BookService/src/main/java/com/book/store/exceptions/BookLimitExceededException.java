package com.book.store.exceptions;

public class BookLimitExceededException extends RuntimeException{
    public BookLimitExceededException() {
        super("Book limit exceeded, Author cannot keep more than 3 incomplete Books");
    }
}
