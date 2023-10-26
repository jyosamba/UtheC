package com.UtheC2.UtheC2.Controllers;

import com.UtheC2.UtheC2.Entities.BooksEntity;
import com.UtheC2.UtheC2.Services.BookServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookServices bookService;

    @GetMapping("/allbooks")
    public ResponseEntity<?> getBooks(){
        List<BooksEntity> booksList = bookService.getAllBooks();

        if(booksList.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No books found");
        }

        return ResponseEntity.ok(booksList);
    }

    @GetMapping("/allbooks/{bookID}")
    public ResponseEntity<?> getBooksbyID(@PathVariable int bookID){
        List<BooksEntity> booksList = bookService.getBookBybookID(bookID);

        if(booksList.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No books found for the '"+bookID+"' genre. Sorry!!");
        }

        return ResponseEntity.ok(booksList);
    }
}
