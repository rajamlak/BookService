package com.book.store.dto;

public class CreateBookDTO {
    private Long userId;
    private String title;
    private Double price;
    private Integer pages;
    private String description;
    private String content;

    public CreateBookDTO(Long userId, String title, Double price, Integer pages, String description, String content) {
        this.userId = userId;
        this.title = title;
        this.price = price;
        this.pages = pages;
        this.description = description;
        this.content = content;
    }

    public CreateBookDTO() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
