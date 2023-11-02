package com.UtheC2.UtheC2.Services;

import com.UtheC2.UtheC2.Entities.BooksEntity;
import com.UtheC2.UtheC2.repos.BooksRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServices {
    @Autowired
    private BooksRepo RepoB;

    public List<BooksEntity> findBooksbyGenreID(int genreID){
        //Retrieving Books depending on a specific Genre
        List<BooksEntity> booksList = RepoB.findByGenreGenreID(genreID);
        return booksList;
    }

    public List<BooksEntity> findBooksbyAuthorID(int authorID){
        //Retrieving Books depending on a specific Author
        List<BooksEntity> bookList = RepoB.findByAuthorAuthorIDAndHardcover(authorID,true);
        bookList.addAll(RepoB.findByAuthorAuthorIDAndHardcover(authorID, false));
        return bookList;
    }

    public List<BooksEntity> getAllBooks(){
        List<BooksEntity> booksList = RepoB.findAll();

        return booksList;
    }

    public List<BooksEntity> getBookBybookID(int bookID){
        List<BooksEntity> booksList = RepoB.findBookBybookID(bookID);

        return booksList;
    }


}
