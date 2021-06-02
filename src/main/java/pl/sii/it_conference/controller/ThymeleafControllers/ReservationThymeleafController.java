package pl.sii.it_conference.controller.ThymeleafControllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.sii.it_conference.dto.ReservationDto;
import pl.sii.it_conference.dto.ReservationVO;
import pl.sii.it_conference.service.ReservationService;
import springfox.documentation.annotations.ApiIgnore;

@Controller
@AllArgsConstructor
public class ReservationThymeleafController {
    private final ReservationService reservationService;


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
}
