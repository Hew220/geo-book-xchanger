package hu.wup.geobookxchanger.services;


import hu.wup.geobookxchanger.model.User;

import java.util.List;

public interface UserService {

    User getUserByName(String name);

    List<User> getAllUser();

    void insertUser(User user);

    void updateSetOfBooks(String username, String title);




}
