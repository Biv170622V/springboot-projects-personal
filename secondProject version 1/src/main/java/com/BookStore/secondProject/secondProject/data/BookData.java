package com.BookStore.secondProject.secondProject.data;

import com.BookStore.secondProject.secondProject.entity.BookStore;
import java.util.List;

//this class is to return object to data field it can be hashmap or list or anything else
public class BookData {

    private List<BookStore> books;

    public List<BookStore> getBooks() {
        return books;
    }

    public void setBooks(List<BookStore> books) {
        this.books = books;
    }
}
