package hu.wup.geobookxchanger.services;

import hu.wup.geobookxchanger.model.Book;
import hu.wup.geobookxchanger.repositories.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

class BookServiceImplTest {

    @Mock
    BookRepository bookRepository;

    BookService bookService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        bookService = new BookServiceImpl(bookRepository);
    }

    @Test
    void getAllBooks() {
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book());

        when(bookRepository.findAll()).thenReturn(bookList);

        List<Book> returnedBookList = bookService.getAllBooks();

        assertEquals(1, returnedBookList.size());
    }

    @Test
    void getBookById() {
        Long id = 2L;
        Book book = new Book();
        book.setId(id);
        Optional<Book> bookOptionalMocked = Optional.of(book);

        when(bookRepository.findById(anyLong())).thenReturn(bookOptionalMocked);

        Book returnedBook = bookService.getBookById(2L);
        assertNotNull(returnedBook);
        verify(bookRepository, times(1)).findById(anyLong());

    }
}