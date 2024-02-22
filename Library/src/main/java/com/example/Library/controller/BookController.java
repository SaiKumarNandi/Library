package com.example.Library.controller;

import com.example.Library.model.Book;
import com.example.Library.model.Member;
import com.example.Library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;



    // create a member
    @PostMapping
    public Book createBook(@RequestBody  Book book){
        return bookService.createBook(book);
    }

    @PutMapping("/update")
    public Book modifyBook(@RequestParam int bookId,@RequestBody Book book){

        return bookService.modifyBook(bookId,book);
    }

    @DeleteMapping("/delete")
    public String deleteBook(@RequestParam int bookId){
        return bookService.deleteBook(bookId);
    }

    @GetMapping("/get")
    public Book getBookData(@RequestParam int bookId){
        return bookService.getBookData(bookId);
    }


    @GetMapping("/getAll")
    public Collection getAllBookData(){
        return bookService.getAllBookData();
    }
}