package hu.wup.geobookxchanger.gw.services;


import hu.wup.geobookxchanger.gw.api.model.Book;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BookHistoryService {

    void hideBookByUser(Long userId, Long bookId, String location, String description);

    ResponseEntity<List<Book>> getListOfBooksByUser(Long userId);

//    BookHistoryRequest convertBookHistoryEntityIntoBookHistoryRequest(BookHistoryEntity bookHistoryEntity);

//    BookHistoryEntity convertBookRequestIntoBookHistoryEntity(BookHistoryRequest bookHistoryRequest);

}