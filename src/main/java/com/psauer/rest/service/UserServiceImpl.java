package com.psauer.rest.service;

import com.psauer.rest.domain.User;
import com.psauer.rest.persistence.UserRepository;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Service
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  @Autowired
  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public List<User> findUsers() {
    return userRepository.findAll();
  }

  @Override
  public Optional<User> findUser(String eMailAddress) {
    return userRepository.findByEMailAddress(eMailAddress);
  }

  @Override
  public ResponseEntity<?> saveUser(User user) {
    User result = userRepository.save(user);
    URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{eMailAddress}")
        .buildAndExpand(result.getEMailAddress()).toUri();
    return ResponseEntity.created(location).build();
  }

  @Override
  public void deleteUser(String eMailAddress) {
    userRepository.deleteByEMailAddress(eMailAddress);
  }

  @Override
  public void updateUserCompletely(String eMailAddress, User user) {
    Optional<User> retrievedUser = userRepository.findByEMailAddress(eMailAddress);

    retrievedUser.ifPresent(u -> {
      user.setId(u.getId());
      userRepository.save(user);
    });
  }

  @Override
  public void updateUserPartially(String eMailAddress, User user) {
    Optional<User> retrievedUser = userRepository.findByEMailAddress(eMailAddress);

    retrievedUser.ifPresent(u -> {
      u.setUsername(user.getUsername());
      userRepository.save(u);
    });
  }

}
