package com.example.demo.controller;

import com.example.demo.response.UserRest;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UsersController {

  @GetMapping("/status/check")
  public String getStatus() {
    return "Work in progress...";
  }

  @PreAuthorize("hasAnyAuthority('ROLE_developer') or #id == #jwt.subject")
//  @Secured("ROLE_developer")
  @DeleteMapping(path = "/{id}")
  public String deleteUser(@PathVariable String id, @AuthenticationPrincipal Jwt jwt) {
    return "Deleted user with id " + id + jwt.getSubject();
  }

  @PostAuthorize("returnObject.userId == #jwt.subject")
  @GetMapping(path = "/{id}")
  public UserRest getUser(@PathVariable String id, @AuthenticationPrincipal Jwt jwt) {
    return new UserRest("Oleg", "Pasichnyk", null);
  }
}
