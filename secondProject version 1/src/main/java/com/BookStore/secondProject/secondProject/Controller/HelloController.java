package com.BookStore.secondProject.secondProject.Controller;

import com.BookStore.secondProject.secondProject.Service.BookService;
import com.BookStore.secondProject.secondProject.common.ApiResponse;
import com.BookStore.secondProject.secondProject.dto.BookstoreDTO;
import com.BookStore.secondProject.secondProject.entity.BookStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/second")
public class HelloController {

    @Autowired
    private BookService bookService;

    @GetMapping("/hello")
    public String Hello(){
        return "Hello";
    }
    //to get all the books from the store
    @GetMapping("/books")
    public List<BookStore> getAllBooks(){
        return bookService.getAllBooks();
    }
    //to get books by id
    @GetMapping("/{id}")
    public BookstoreDTO getBooksByID(@PathVariable Long id,
                                     @RequestParam(value = "authorData",required = false)boolean authorData){
        return bookService.getBooksByID(id,authorData);
    }
    // to insert book into repo
    @PostMapping("/books")
    public BookStore createBook(@RequestBody BookStore bookStore){
        return bookService.createBook(bookStore);
    }
    //update the book values
    @PutMapping("/books")
    public BookStore updateBook(@RequestBody BookStore bookStore){
        return bookService.updateBook(bookStore);
    }
    //delete the book
    @DeleteMapping("/books/{id}")
    public String deleteBook(@PathVariable Long id){
        return bookService.deleteBook(id);
    }
    //to get all the book that matching query param
    @GetMapping("/books/request")
    public List<BookStore> getAllBooksByQueryParam(@RequestParam("yearofpublication") Integer yop){
        return bookService.getAllBooksByQueryParam(yop);
    }
    // to get all the books by rawquery
    @GetMapping("/raw/books")
    public ApiResponse getBookByRawQuery(@RequestParam(value = "yop") Set<Integer> yop){
        return bookService.getBooksByRawQuery(yop);
    }
    //global exception handler
    @GetMapping("/caughtException")
    public ApiResponse getCaughtException(@RequestParam(value = "number") Integer number){
        return bookService.getCaughtException(number);
    }

}
