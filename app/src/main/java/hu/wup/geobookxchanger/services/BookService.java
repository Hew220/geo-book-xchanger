package hu.wup.geobookxchanger.services;

import hu.wup.geobookxchanger.model.Book;

import java.util.List;

public interface BookService {

    List<Book> getAllBooks();

    Book getBookById(Long id);

    Book getBookByTitle(String title);

    void insertBook(Book book);

    void deleteBook(long id);

    void updateBook(long id, Book book);

    List<Book> getAllBookByTitleASC();

    List<Book> getAllBookByTitleDESC();





}
