package com.UtheC2.UtheC2.repos;

import com.UtheC2.UtheC2.Entities.BooksEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BooksRepo extends JpaRepository<BooksEntity,Integer> {
    //For GenreController to get books by GenreID
    List<BooksEntity> findByGenreGenreID(int genreID);

    //For AuthorController to get books by authorID
    List<BooksEntity> findByAuthorAuthorIDAndHardcover(int authorID,boolean hardcover);

    List<BooksEntity> findBookBybookID(int bookID);

}
