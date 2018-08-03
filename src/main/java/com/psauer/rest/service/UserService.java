package com.psauer.rest.service;

import com.psauer.rest.domain.User;
import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;

public interface UserService {

  List<User> findUsers();

  Optional<User> findUser(String eMailAddress);

  ResponseEntity<?> saveUser(User user);

  void deleteUser(String eMailAddress);

  void updateUserCompletely(String eMailAddress, User user);

  void updateUserPartially(String eMailAddress, User user);
}
