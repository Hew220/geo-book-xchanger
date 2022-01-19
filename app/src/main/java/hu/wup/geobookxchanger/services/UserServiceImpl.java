package hu.wup.geobookxchanger.services;

import hu.wup.geobookxchanger.exceptions.BookNotFoundException;
import hu.wup.geobookxchanger.exceptions.UserIsAlreadyExist;
import hu.wup.geobookxchanger.exceptions.UserNotFoundException;
import hu.wup.geobookxchanger.model.Book;
import hu.wup.geobookxchanger.model.User;
import hu.wup.geobookxchanger.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BookService bookService;

    public UserServiceImpl(UserRepository userRepository, BookService bookService) {
        this.userRepository = userRepository;
        this.bookService = bookService;
    }


    @Override
    public User getUserByName(String name) {
        Optional<User> userOptional = userRepository.findByName(name);
        if (userOptional.isPresent()) {
            return userOptional.get();
        }
        return null;
    }

    @Override
    public List<User> getAllUser() {
        List<User> listOfUsers = new ArrayList<>();
        userRepository.findAll().iterator().forEachRemaining(listOfUsers::add);
        return listOfUsers;
    }

    @Override
    public void insertUser(User user) {
        User existingUser = getUserByName(user.getName());
        if(existingUser == null) {
            userRepository.save(user);
        }else {
            throw new UserIsAlreadyExist("User is being registered by this name: " + user.getName());
        }
    }

    @Override
    public void updateSetOfBooks(String username, String title) {
        User existingUser = getUserByName(username);
        Book existingBook = bookService.getBookByTitle(title);
        if (existingUser == null) {
            throw new UserNotFoundException("User has not been found by this username: " + username);
        }else if(existingBook == null) {
            throw new BookNotFoundException("Book has not been found by this title " + title);
        }else {
            existingUser.getBooks().add(existingBook);
            userRepository.save(existingUser);
        }
    }

}
