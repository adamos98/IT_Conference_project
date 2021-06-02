package pl.sii.it_conference.controller.ThymeleafControllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.sii.it_conference.dto.PrelectionVO;
import pl.sii.it_conference.dto.ReservationVO;
import pl.sii.it_conference.dto.UserDto;
import pl.sii.it_conference.entity.User;
import pl.sii.it_conference.service.PrelectionService;
import pl.sii.it_conference.service.ReservationService;
import springfox.documentation.annotations.ApiIgnore;

@Controller
@AllArgsConstructor
public class ReservationThymeleafController {
    private final ReservationService reservationService;
    private final PrelectionService prelectionService;


    @ApiIgnore
    @GetMapping("/showUserReservations")
    public String showReservations(@RequestParam(required = false) String login, Model model, ReservationVO reservationVO){
        model.addAttribute("reservationVO",reservationVO);
        model.addAttribute("login",login);
        model.addAttribute("listOfReservations", reservationService.showReservationsByLogin(login));
        return "showuserprelections";
    }

    @ApiIgnore
    @PostMapping("/deleteReservation")
    public String deleteReservation(@RequestParam(required = false) String login,@RequestParam(required = false) Long id,
                                    Model model, ReservationVO reservationVO){
        model.addAttribute("reservationVO",reservationVO);
        model.addAttribute("id",id);
        model.addAttribute("login",login);
        reservationService.deleteReservation(id);
        return "redirect:/showUserReservations?login=" + login;
    }

    @ApiIgnore
    @PostMapping("/addNewReservation")
    public String addNewReservation(@RequestParam(required = false)String login, @RequestParam(required = false) String email,
                                    @RequestParam(required = false) Long id, Model model){
        model.addAttribute("prelectionList", prelectionService.getAllPrelections());
        model.addAttribute("id",id);
        model.addAttribute("email",email);
        model.addAttribute("login",login);
        UserDto userDto = new UserDto(login,email);
        reservationService.addNewReservation(userDto,id);
        return "redirect:/";
    }

    @ApiIgnore
    @GetMapping("/addNewReservationView")
    public String addNewReservationView(String login, String email, Model model, PrelectionVO prelectionVO){
        model.addAttribute("prelectionList", prelectionService.getAllPrelections());
        model.addAttribute("prelectionVO", prelectionVO);
        model.addAttribute("email",email);
        model.addAttribute("login",login);
        return "addnewreservation";
    }

}
