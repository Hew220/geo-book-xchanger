package hu.wup.geobookxchanger.services;


import hu.wup.geobookxchanger.model.User;

import java.util.List;

public interface UserService {

    User getUserById(Long id);

    User getUserByName(String name);

    List<User> getAllUser();

    void insertUser(User user);




}
