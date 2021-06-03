package pl.sii.it_conference.controller.ThymeleafControllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.sii.it_conference.dto.UserDto;
import pl.sii.it_conference.service.UserService;
import springfox.documentation.annotations.ApiIgnore;

@Controller
@AllArgsConstructor
public class UserThymeleafController {
    private final UserService userService;

    @ApiIgnore
    @GetMapping("/showAllRegisteredUsers")
    public String getAllUsers(Model model){
        model.addAttribute("listOfUsers", userService.getAllUsers());
        return "registeredusers";
    }

    @ApiIgnore
    @PostMapping("/updateUserEmail")
    public String updateUserEmail(@RequestParam String email,@RequestParam String login, Model model){
        model.addAttribute("email", email);
        model.addAttribute("login", login);
        UserDto userDto = new UserDto(login,email);
        userService.updateEmail(userDto);
        return "redirect:/";
    }

    @ApiIgnore
    @GetMapping("/updateEmail")
    public String updateEmail(String email, String login, Model model){
        model.addAttribute("email",email);
        model.addAttribute("login",login);
        return "updateemail";
    }
}
