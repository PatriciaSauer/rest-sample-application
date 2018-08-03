package com.psauer.rest.persistence;

import com.psauer.rest.domain.User;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

  Optional<User> findByEMailAddress(String eMailAddress);

  void deleteByEMailAddress(String eMailAddress);

}
