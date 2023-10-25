package com.UtheC2.UtheC2.Controllers;

import com.UtheC2.UtheC2.DTO.BooksNamesDTO;
import com.UtheC2.UtheC2.Entities.BooksEntity;
import com.UtheC2.UtheC2.Services.BookServices;
import com.UtheC2.UtheC2.repos.GenresRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/genres")
public class GenresController {
    @Autowired
    private BookServices bookService;

    @GetMapping("/books-genre/{genreID}")
    public ResponseEntity<?> getBooksbyGenre(@PathVariable int genreID){
        List<BooksEntity> booksList = bookService.findBooksbyGenreID(genreID);

        if(booksList.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No books found for the '"+genreID+"' genre. Sorry!!");
        }
        List<BooksNamesDTO> bookNamesList = new ArrayList<>();
        for(BooksEntity book : booksList){
            bookNamesList.add(new BooksNamesDTO(book.getTitle()));
        }
        return ResponseEntity.ok(bookNamesList);
    }

}
