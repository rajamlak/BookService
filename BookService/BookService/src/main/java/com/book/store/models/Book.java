package com.book.store.models;
import com.book.store.enums.BookEditStatusEnum;
import com.book.store.enums.BookStatusEnum;
import org.hibernate.Hibernate;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long user;
    private String title;
    private Double price;
    private Integer pages;
    private String description;
    @Column(length = 3000, columnDefinition = "TEXT")
    private String content;
    private BookEditStatusEnum editStatus;
    private BookStatusEnum bookStatus;
    private LocalDateTime createdAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Book book = (Book) o;
        return getId() != null && Objects.equals(getId(), book.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
	public Book() {
		super();
	}
	public Book(Long id, Long user, String title, Double price, Integer pages, String description, String content,
			BookEditStatusEnum editStatus, BookStatusEnum bookStatus, LocalDateTime createdAt) {
		super();
		this.id = id;
		this.user = user;
		this.title = title;
		this.price = price;
		this.pages = pages;
		this.description = description;
		this.content = content;
		this.editStatus = editStatus;
		this.bookStatus = bookStatus;
		this.createdAt = createdAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUser() {
		return user;
	}

	public void setUser(Long user) {
		this.user = user;
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

	public BookEditStatusEnum getEditStatus() {
		return editStatus;
	}

	public void setEditStatus(BookEditStatusEnum editStatus) {
		this.editStatus = editStatus;
	}

	public BookStatusEnum getBookStatus() {
		return bookStatus;
	}

	public void setBookStatus(BookStatusEnum bookStatus) {
		this.bookStatus = bookStatus;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	
	
    

}
