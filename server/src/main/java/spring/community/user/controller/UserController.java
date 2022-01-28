package spring.community.user.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.community.user.dto.UserDto;
import spring.community.user.entity.User;
import spring.community.user.service.UserService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("userTest")
public class UserController {

  @Autowired
  UserService userService;


  @Operation(summary = "유저 id로 찾기")
  @GetMapping(value = "/{userId}")
  public ResponseEntity<UserDto> getUserById(@PathVariable("userId") Long userId) {
    System.out.println("userId: " + userId);
    Optional<User> user = userService.findById(userId);
    UserDto dto = user.get().toUserDto();
      return ResponseEntity.ok(dto);
  }

  @Operation(summary = "모든 유저 찾기")
  @GetMapping(value = "/findAll")
  public ResponseEntity<List<UserDto>> getAllUsers() {
    List<UserDto> dtoList = userService.findAll()
            .stream()
            .map(User::toUserDto)
            .collect(Collectors.toList());
    return ResponseEntity.ok(dtoList);
  }
}
