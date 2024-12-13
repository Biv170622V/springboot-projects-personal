package com.BookStore.secondProject.secondProject.entity;

import jakarta.persistence.*;

@Entity
public class BookAuthor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "book_id",referencedColumnName = "id",nullable = false)
    private BookStore book;

    @ManyToOne
    @JoinColumn(name = "author_id",referencedColumnName = "id",nullable = false)
    private Author author;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public BookStore getBook() {
        return book;
    }

    public void setBook(BookStore book) {
        this.book = book;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
