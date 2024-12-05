package com.BookStore.secondProject.secondProject.Service;

import com.BookStore.secondProject.secondProject.Repo.BookRepository;
import com.BookStore.secondProject.secondProject.utility.BookStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    public List<BookStore> getAllBooks() {
    List<BookStore> bookStoreList = new ArrayList<>();
    bookRepository.findAll().forEach(bookStore -> bookStoreList.add(bookStore));
    return bookStoreList;
    }

    public Optional<BookStore> getBooksByID(Long id) {
        return bookRepository.findById(id);
    }

    public BookStore createBook(BookStore bookStore) {
        if (bookStore == null) {
            throw new IllegalArgumentException("BookStore object cannot be null.");
        }
        // Validate the name
        if (bookStore.getName() == null || bookStore.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Book name cannot be null or empty.");
        }
        // Validate the description
        if (bookStore.getDescription() == null || bookStore.getDescription().length() < 10) {
            throw new IllegalArgumentException("Book description must be at least 10 characters long.");
        }
        // Validate the year of publication
        int currentYear = java.time.Year.now().getValue();
        if (bookStore.getYearofpublication() == null ||
                bookStore.getYearofpublication() < 1500 ||
                bookStore.getYearofpublication() > currentYear) {
            throw new IllegalArgumentException("Year of publication must be between 1500 and " + currentYear + ".");
        }
        // Validate the book type
        if (bookStore.getBooktype() == null || bookStore.getBooktype().trim().isEmpty()) {
            throw new IllegalArgumentException("Book type cannot be null or empty.");
        }

        return bookRepository.save(bookStore);
    }

    public BookStore updateBook(BookStore bookStore) {
        if (bookStore == null) {
            throw new IllegalArgumentException("BookStore object cannot be null.");
        }
        // Validate the name
        if (bookStore.getName() == null || bookStore.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Book name cannot be null or empty.");
        }
        // Validate the description
        if (bookStore.getDescription() == null || bookStore.getDescription().length() < 10) {
            throw new IllegalArgumentException("Book description must be at least 10 characters long.");
        }
        // Validate the year of publication
        int currentYear = java.time.Year.now().getValue();
        if (bookStore.getYearofpublication() == null ||
                bookStore.getYearofpublication() < 1500 ||
                bookStore.getYearofpublication() > currentYear) {
            throw new IllegalArgumentException("Year of publication must be between 1500 and " + currentYear + ".");
        }
        // Validate the book type
        if (bookStore.getBooktype() == null || bookStore.getBooktype().trim().isEmpty()) {
            throw new IllegalArgumentException("Book type cannot be null or empty.");
        }

        return bookRepository.save(bookStore);
    }

    public String deleteBook(Long id) {
        bookRepository.deleteById(id);
        return "Deleted successfully";
    }

    public List<BookStore> getAllBooksByQueryParam(Integer yop) {
        return bookRepository.findAllByyearofpublication(yop);
    }

    public List<BookStore> getBooksByRawQuery(Set<Integer> yop) {
       List<BookStore> booklist= bookRepository.getBooksByYopIn(yop);
       return booklist;
    }
}
