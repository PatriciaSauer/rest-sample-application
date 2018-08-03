package com.psauer.rest.controller;

import com.psauer.rest.domain.User;
import com.psauer.rest.service.UserService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

  private final UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping
  public List<User> findUsers() {
    return userService.findUsers();
  }

  @GetMapping("/{eMailAddress}")
  public Optional<User> findUserByEMailAddress(@PathVariable String eMailAddress) {
    return userService.findUser(eMailAddress);
  }

  @PostMapping
  public ResponseEntity<?> postUser(@RequestBody User user) {
    return userService.saveUser(user);
  }

  @DeleteMapping("/{eMailAddress}")
  public void deleteUser(@PathVariable String eMailAddress) {
    userService.deleteUser(eMailAddress);
  }

  @PutMapping("/{eMailAddress}")
  public void updateUser(@PathVariable String eMailAddress, @RequestBody User user) {
    userService.updateUserCompletely(eMailAddress, user);
  }

  @PatchMapping("/{eMailAddress}")
  public void patchUser(@PathVariable String eMailAddress,
      @RequestBody User user) {
    userService.updateUserPartially(eMailAddress, user);
  }

}
