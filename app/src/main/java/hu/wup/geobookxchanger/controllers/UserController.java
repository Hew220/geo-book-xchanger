package hu.wup.geobookxchanger.controllers;

import hu.wup.geobookxchanger.api.UserApi;
import hu.wup.geobookxchanger.model.User;
import hu.wup.geobookxchanger.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController implements UserApi {

    private  final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @Override
    public ResponseEntity<User> addNewUser(User user) {

        userService.insertUser(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> listOfUsers = userService.getAllUser();
        return new ResponseEntity<>(listOfUsers, HttpStatus.OK);

    }

    @Override
    public ResponseEntity<User> getUserByName(String username) {
        User user = userService.getUserByName(username);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
