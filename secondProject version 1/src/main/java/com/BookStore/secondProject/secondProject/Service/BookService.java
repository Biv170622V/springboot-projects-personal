package com.BookStore.secondProject.secondProject.Service;

import com.BookStore.secondProject.secondProject.Repo.AuthorRepository;
import com.BookStore.secondProject.secondProject.Repo.BookAuthorRepository;
import com.BookStore.secondProject.secondProject.Repo.BookRepository;
import com.BookStore.secondProject.secondProject.common.ApiResponse;
import com.BookStore.secondProject.secondProject.data.BookData;
import com.BookStore.secondProject.secondProject.dto.AuthorDTO;
import com.BookStore.secondProject.secondProject.dto.BookstoreDTO;
import com.BookStore.secondProject.secondProject.entity.Author;
import com.BookStore.secondProject.secondProject.entity.BookAuthor;
import com.BookStore.secondProject.secondProject.entity.BookStore;
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

    @Autowired
    private BookAuthorRepository bookAuthorRepository ;

    public List<BookStore> getAllBooks() {
    List<BookStore> bookStoreList = new ArrayList<>();
    bookRepository.findAll().forEach(bookStore -> bookStoreList.add(bookStore));
    return bookStoreList;
    }
//to retuen both bookstore and author data
    public BookstoreDTO getBooksByID(Long id, boolean authorData) {
        //return bookRepository.findById(id);
        Optional<BookStore> book;
        List<BookAuthor> bookAuthors = null;
        book = bookRepository.findById(id);
        if(authorData){
            bookAuthors = bookAuthorRepository.findAllById(id);
            System.out.println(bookAuthors);
        }
        //set book details
        BookstoreDTO bookstoreDTO = new BookstoreDTO();
        bookstoreDTO.setId(book.get().getId());
        bookstoreDTO.setName(book.get().getName());
        bookstoreDTO.setDescription(book.get().getDescription());
        bookstoreDTO.setYearofpublication(book.get().getYearofpublication());
        bookstoreDTO.setBooktype(book.get().getDescription());

        //get author details
        List<AuthorDTO> authorDTOList = new ArrayList<>();
        if(bookAuthors!=null) {
            for (BookAuthor bookAuthor : bookAuthors) {
                Author author = bookAuthor.getAuthor();

                AuthorDTO authordto = new AuthorDTO();
                authordto.setId(author.getId());
                authordto.setName(author.getName());
                authordto.setGender(author.getGender());

                authorDTOList.add(authordto);
            }
            bookstoreDTO.setAuthorDTOS(authorDTOList);
        }
        return bookstoreDTO;
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

    public ApiResponse getBooksByRawQuery(Set<Integer> yop) {
        ApiResponse apiResponse = new ApiResponse();
        //db call
       List<BookStore> booklist= bookRepository.getBooksByYopIn(yop);
        //set data
        BookData bookData = new BookData();
        bookData.setBooks(booklist);
        //set api response
       apiResponse.setData(bookData);
       return apiResponse;
    }
    //global exception handler function
    public ApiResponse getCaughtException(Integer number) {
        int result = 100/number;
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setData(result);
        return apiResponse;
    }
}
