package hu.wup.geobookxchanger.services;

import hu.wup.geobookxchanger.exceptions.BookIsAlreadyExistException;
import hu.wup.geobookxchanger.exceptions.BookNotFoundException;
import hu.wup.geobookxchanger.model.Book;
import hu.wup.geobookxchanger.repositories.BookRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    private static final Logger logger = LogManager.getLogger(BookServiceImpl.class);

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }



    @Override
    public List<Book> getAllBooks() {
        List<Book> bookList = new ArrayList<>();
        bookRepository.findAll().iterator().forEachRemaining(bookList::add);
        return bookList;
    }

    @Override
    public Book getBookById(Long id)  {
        Optional<Book> bookOptional = bookRepository.findById(id);
        Book book;
        if(bookOptional.isPresent()) {
            book = bookOptional.get();
        }else {
            logger.error("Book hasn't been found by this id:" + id);
            throw new BookNotFoundException(" Book has not been found by this id " + id);
        }
        logger.debug(bookOptional.get());
        return book;

    }

    @Override
    public Book getBookByTitle(String title) {
        Optional<Book> result = bookRepository.findByTitle(title);
        if(result.isPresent()) {
            return result.get();
        }
        return null;
    }


    @Override
    public void insertBook(Book book) {
        Book existingBook = getBookByTitle(book.getTitle());
        if(existingBook == null) {
            bookRepository.save(book);
        }else {
            throw new BookIsAlreadyExistException("Book is already exist by this title " + book.getTitle());
        }
    }

    @Override
    public void deleteBook(long bookId) {
        boolean exists = bookRepository.existsById(bookId);
        logger.debug("deleteBook by: " + bookId);
        if (!exists) {
            throw new BookNotFoundException("Book does not exist by this id " + bookId);
        }
        bookRepository.deleteById(bookId);
    }

    @Override
    public void updateBook(long bookId, Book book) {

        Book existingBook = bookRepository.findById(bookId).orElse(null);
        logger.debug("updateBook by: " + bookId);
        if (existingBook == null) {
            throw new BookNotFoundException("Book does not exist by this id " + bookId);
        }else {
         existingBook.setAuthor(book.getAuthor());
         existingBook.setTitle(book.getTitle());
        }
        bookRepository.save(existingBook);
    }

    @Override
    public List<Book> getAllBookByTitleASC() {
        Optional<List<Book>> result = bookRepository.findAllByOrderByTitleAsc();
        return result.get();
    }

    @Override
    public List<Book> getAllBookByTitleDESC() {
        Optional<List<Book>> result = bookRepository.findAllByOrderByTitleDesc();
        return result.get();
    }
}
