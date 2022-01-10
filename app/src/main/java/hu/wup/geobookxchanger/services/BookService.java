package hu.wup.geobookxchanger.services;

import hu.wup.geobookxchanger.model.Book;

import java.util.List;

public interface BookService {

    Iterable<Book> getAllBooks();

    Book getBookById(long id);

    Book getBookByTitle(String title);

    void insertBook(Book book);

    void deleteBook(long id);

    void updateBook(long id, Book book);

    List<Book> getAllBookByTitleASC();

    List<Book> getAllBookByTitleDESC();





}
