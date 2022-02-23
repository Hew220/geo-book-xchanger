package hu.wup.geobookxchanger.gw.services;

import hu.wup.geobookxchanger.gw.api.model.Book;
import hu.wup.geobookxchanger.ms.api.BookHistoryApiClient;
import hu.wup.geobookxchanger.ms.api.model.HideBookHistoryRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class BookHistoryServiceImpl implements BookHistoryService {

    @Autowired
    private BookHistoryApiClient bookHistoryApiClient;




    public BookHistoryServiceImpl() {


    }

    @Override
    public void hideBookByUser(Long userId, Long bookId, String location, String description) {

        HideBookHistoryRequest msRequest =  new HideBookHistoryRequest();
        msRequest.setBookId(bookId);
        msRequest.setUserId(userId);
        msRequest.setLocation(location);
        msRequest.setDescription(description);
        bookHistoryApiClient.hideBookByUser(msRequest);

    }

    @Override
    public ResponseEntity<List<Book>> getListOfBooksByUser(Long userId) {
        RestTemplate restTemplate = new RestTemplate();
        String resourceUrl = "http://localhost:8080/getlistofbookbyuser/" + userId;
        ResponseEntity<List<Book>> response = restTemplate.exchange(resourceUrl, HttpMethod.GET, null, new ParameterizedTypeReference<List<Book>>() {});
        return response;
    }


}
