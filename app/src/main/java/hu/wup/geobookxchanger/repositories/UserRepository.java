package hu.wup.geobookxchanger.repositories;

import hu.wup.geobookxchanger.model.Book;
import hu.wup.geobookxchanger.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User,Long> {

    Optional<User> findByName(String name);
}
