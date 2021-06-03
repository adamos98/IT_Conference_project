package pl.sii.it_conference.controller;

import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sii.it_conference.dto.UserDto;
import pl.sii.it_conference.dto.UserWithIdDto;
import pl.sii.it_conference.service.UserService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @ApiOperation("Get user by id")
    @GetMapping("/{id}")
    public UserWithIdDto getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @ApiOperation("Get user by login")
    @GetMapping("/login/{login}")
    public UserWithIdDto getUserByLogin(@PathVariable String login){
        return userService.findByLogin(login);
    }

    @ApiOperation("Save new user")
    @PostMapping("/addNewUser")
    public ResponseEntity<UserWithIdDto> addNewUser(@RequestBody UserDto userDto){
        UserWithIdDto response = userService.save(userDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @ApiOperation("Update user email")
    @PutMapping("/updateLogin")
    public ResponseEntity<UserDto> updateEmail(@RequestBody UserDto userDto){
        return ResponseEntity.status(HttpStatus.OK).body(userService.updateEmail(userDto));
    }

    @ApiOperation("Get all users")
    @GetMapping("/allUsers")
    public ResponseEntity<List<UserDto>> getAllUsers(){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUsers());
    }

}
