package hu.wup.geobookxchanger.services;

import hu.wup.geobookxchanger.exceptions.UserIsAlreadyExist;
import hu.wup.geobookxchanger.exceptions.UserNotFoundException;
import hu.wup.geobookxchanger.model.User;
import hu.wup.geobookxchanger.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserById(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        User existingUser;
        if (userOptional.isPresent()) {
            existingUser = userOptional.get();
        }else {
            throw new UserNotFoundException("User has not been found by this id: " + userId);
        }

        return existingUser;
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
            throw new UserIsAlreadyExist("User is being registered by the name: " + user.getName());
        }
    }

}
