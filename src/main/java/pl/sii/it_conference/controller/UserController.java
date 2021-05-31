package pl.sii.it_conference.controller;

import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.sii.it_conference.dto.UserVO;
import pl.sii.it_conference.service.UserService;

@RestController
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @ApiOperation("Get user by id")
    @GetMapping("/user/{id}")
    public UserVO getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }
}
