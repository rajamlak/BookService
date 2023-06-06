package com.book.store.dto;


public class PaginationDTO {
    private int page;
    private int size;

    public PaginationDTO(int page, int size) {
        this.page = page;
        this.size = size;
    }

    public PaginationDTO() {
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
