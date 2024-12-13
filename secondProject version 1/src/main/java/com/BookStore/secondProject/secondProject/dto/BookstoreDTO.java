package com.BookStore.secondProject.secondProject.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

public class BookstoreDTO {

    private Long id;
    private String name;
    private String description;
    private Integer yearofpublication;
    private String booktype;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<AuthorDTO> authorDTOS;

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

    public List<AuthorDTO> getAuthorDTOS() {
        return authorDTOS;
    }

    public void setAuthorDTOS(List<AuthorDTO> authorDTOS) {
        this.authorDTOS = authorDTOS;
    }
}
