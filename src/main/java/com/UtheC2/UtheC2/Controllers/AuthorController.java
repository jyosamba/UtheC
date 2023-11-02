package com.UtheC2.UtheC2.Controllers;

import com.UtheC2.UtheC2.DTO.BooksNamesDTO;
import com.UtheC2.UtheC2.Entities.BooksEntity;
import com.UtheC2.UtheC2.Services.BookServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private BookServices bookService;
    @GetMapping("/{authorID}/books")
    public ResponseEntity<?> getBooksbyAuthor(@PathVariable int authorID){
        List<BooksEntity> booksList = bookService.findBooksbyAuthorID(authorID);

        if(booksList.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sorry!! We do not have any books by that author at the moment!"
            );
        }

        List<BooksNamesDTO> bookNamesList = new ArrayList<>();

        for(BooksEntity book : booksList){
            bookNamesList.add(new BooksNamesDTO(book.getTitle()));
        }

        return ResponseEntity.ok(bookNamesList);
    }
}
