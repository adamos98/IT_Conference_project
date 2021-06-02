package pl.sii.it_conference.controller.ThymeleafControllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.sii.it_conference.service.PrelectionService;
import springfox.documentation.annotations.ApiIgnore;

@Controller
@AllArgsConstructor
public class PrelectionThymeleafController {
    private final PrelectionService prelectionService;

    @ApiIgnore
    @GetMapping("/showConferencePlan")
    public String getAllPrelections(Model model){
        model.addAttribute("listOfPrelections", prelectionService.getAllPrelections());
        return "conferenceplan";
    }


}
