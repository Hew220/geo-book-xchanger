package hu.wup.geobookxchanger.controllers;

import hu.wup.geobookxchanger.api.BookApi;
import hu.wup.geobookxchanger.model.Book;
import hu.wup.geobookxchanger.services.BookService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping(path = "/book")
public class BookController implements BookApi {

    private final BookService bookService;
    private static final Logger logger = LogManager.getLogger(BookController.class);

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @Override
    public @ResponseBody ResponseEntity<Book> addNewBook(@RequestBody Book book) {

        bookService.insertBook(book);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @Override
    public @ResponseBody ResponseEntity<Book> deleteBook(@PathVariable("bookId") Long bookId) {
        bookService.deleteBook(bookId);
        return new ResponseEntity<>(new Book(bookId), HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> listOfBooks = bookService.getAllBooks();
        return new ResponseEntity<>(listOfBooks, HttpStatus.OK);
    }


    @Override
    public ResponseEntity<Book> getBookById(@PathVariable Long bookId) {
        Book book = bookService.getBookById(bookId);
        logger.info("Book id: " + book.getId());
        return new ResponseEntity<>(book, HttpStatus.OK);

    }

    @Override
    public ResponseEntity<List<Book>> sortBooksByTitle(@RequestParam String title) {
        List<Book> bookList = null;
        if(title.equals("asc")) {
           bookList = bookService.getAllBookByTitleASC();
        }else if(title.equals("desc")) {
            bookList = bookService.getAllBookByTitleDESC();
        }
        return new ResponseEntity<>(bookList, HttpStatus.OK);
    }

    @Override
    public @ResponseBody ResponseEntity<Book> updateBook(@PathVariable("bookId") Long bookId,
                                                         @RequestBody Book book){
        bookService.updateBook(bookId,book);
        Book updatedBook = bookService.getBookById(bookId);
        return new ResponseEntity<>(updatedBook, HttpStatus.CREATED);

    }

}
