package hu.wup.geobookxchanger.gw.controllers;


import hu.wup.geobookxchanger.gw.api.BookHistoryApi;
import hu.wup.geobookxchanger.gw.api.model.Book;
import hu.wup.geobookxchanger.gw.api.model.HideBookHistoryRequestGW;
import hu.wup.geobookxchanger.gw.api.model.HideBookHistoryResponseGW;
import hu.wup.geobookxchanger.gw.services.BookHistoryService;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/bookhistory")
public class BookHistoryController implements BookHistoryApi {

   private final BookHistoryService bookHistoryService;

    public BookHistoryController(BookHistoryService bookHistoryService) {
        this.bookHistoryService = bookHistoryService;
    }


    @Override
    public ResponseEntity<List<Book>> getBooksByUser(Long userId) {

        ResponseEntity<List<Book>> response = bookHistoryService.getListOfBooksByUser(userId);
        return response;
    }

    @Override
    public ResponseEntity<HideBookHistoryResponseGW> hideBookByUser(HideBookHistoryRequestGW hideBookHistoryRequestGW) {

        Long userId = hideBookHistoryRequestGW.getUserId();
        Long bookId = hideBookHistoryRequestGW.getBookId();
        String location = hideBookHistoryRequestGW.getLocation();
        String description = hideBookHistoryRequestGW.getDescription();

        bookHistoryService.hideBookByUser(userId, bookId, location, description);

        HideBookHistoryResponseGW hideBookHistoryResponseGW = new HideBookHistoryResponseGW();
        hideBookHistoryResponseGW.setUserId(userId);
        hideBookHistoryResponseGW.setBookId(bookId);
        hideBookHistoryResponseGW.setLocation(location);
        hideBookHistoryResponseGW.setDescription(description);
        return new ResponseEntity<>(hideBookHistoryResponseGW, HttpStatus.OK);
    }
}