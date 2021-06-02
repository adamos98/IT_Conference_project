package pl.sii.it_conference.controller;

import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sii.it_conference.dto.UserDto;
import pl.sii.it_conference.dto.UserEmailDto;
import pl.sii.it_conference.dto.UserVO;
import pl.sii.it_conference.service.UserService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @ApiOperation("Get user by id")
    @GetMapping("/{id}")
    public UserVO getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @ApiOperation("Get user by login")
    @GetMapping("/login/{login}")
    public UserVO getUserByLogin(@PathVariable String login){
        return userService.findByLogin(login);
    }

    @ApiOperation("Save new user")
    @PostMapping("/addNewUser")
    public ResponseEntity<UserVO> addNewUser(@RequestBody UserDto userDto){
        UserVO response = userService.save(userDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @ApiOperation("Update user email")
    @PutMapping("/{login}")
    public ResponseEntity<UserDto> updateEmail(@RequestParam String email,
                                          @PathVariable String login){
        return ResponseEntity.status(HttpStatus.OK).body(userService.updateEmail(email,login));
    }

    @ApiOperation("Get all users")
    @GetMapping("/allUsers")
    public ResponseEntity<List<UserDto>> getAllUsers(){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUsers());
    }

}
