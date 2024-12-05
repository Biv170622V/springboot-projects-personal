package com.BookStore.secondProject.secondProject.utility;

import jakarta.persistence.*;

@Entity
@Table(name = "bookstore")
public class BookStore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Integer yearofpublication;
    private String booktype;

    public BookStore() {
    }

    public BookStore(Long id, String name, String description, Integer yearofpublication, String booktype) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.yearofpublication = yearofpublication;
        this.booktype = booktype;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getYearofpublication() {
        return yearofpublication;
    }

    public void setYearofpublication(Integer yearofpublication) {
        this.yearofpublication = yearofpublication;
    }

    public String getBooktype() {
        return booktype;
    }

    public void setBooktype(String booktype) {
        this.booktype = booktype;
    }
}
