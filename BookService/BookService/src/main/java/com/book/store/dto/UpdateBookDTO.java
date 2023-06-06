package com.book.store.dto;

import com.book.store.enums.BookEditStatusEnum;



public class UpdateBookDTO {
    private Long bookId;
    private String content;
    private Integer pages;
    private BookEditStatusEnum editStatus;

    public UpdateBookDTO(Long bookId, String content, Integer pages, BookEditStatusEnum editStatus) {
        this.bookId = bookId;
        this.content = content;
        this.pages = pages;
        this.editStatus = editStatus;
    }

    public UpdateBookDTO() {
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public BookEditStatusEnum getEditStatus() {
        return editStatus;
    }

    public void setEditStatus(BookEditStatusEnum editStatus) {
        this.editStatus = editStatus;
    }
}
