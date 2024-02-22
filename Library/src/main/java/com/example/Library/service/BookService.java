package com.example.Library.service;

import com.example.Library.model.Book;
import com.example.Library.model.Member;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
@Service
public class BookService {
    private Map<Integer, Book> bookMap = new HashMap<>();

    public Book createBook(Book book){

        // call the database
        int bookId = new Random().nextInt();
        book.setBookId(Math.abs(bookId));
        bookMap.put(bookId, book);
        return  book;
    }


    public Book modifyBook(int bookId, Book newbook){
        if(bookMap.containsKey(bookId))
        {

            Book book = bookMap.get(bookId);
            if(!book.getBookName().isEmpty()){
                book.setBookName(newbook.getBookName());
            }
            if(!book.getAuthorName().isEmpty()){
                book.setAuthorName(newbook.getAuthorName());
            }
            if(!book.getBookEdition().isEmpty()){
                book.setBookEdition(newbook.getBookEdition());
            }
            if(book.getBookPrice() != 0.0f){
                book.setBookPrice(newbook.getBookPrice());
            }

            bookMap.put(bookId, newbook);
            System.out.println("updated successfully");
            return book;
        }
        else {
            return null;
        }

    }



    public String deleteBook(int bookId){
        if(bookMap.containsKey(bookId)){
            bookMap.remove(bookId);
            return "Member Deleted Successfully";
        }
        else{
            return "Book Not found";
        }

    }




    public Book getBookData(int bookId){
        return bookMap.get(bookId);
    }


    public Collection getAllBookData(){
        return bookMap.values();
    }


}
