package pl.sii.it_conference.controller;

import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.sii.it_conference.dto.ReservationDto;
import pl.sii.it_conference.dto.ReservationVO;
import pl.sii.it_conference.dto.UserDto;
import pl.sii.it_conference.service.ReservationService;

import java.util.List;

@Controller
@RequestMapping("/reservation")
@AllArgsConstructor
public class ReservationController {
    private final ReservationService reservationService;

    @ApiOperation("Add new reservation")
    @PostMapping("/addReservation/{prelectionId}")
    public ResponseEntity<ReservationVO> addNewReservation(@RequestBody UserDto userDto,@PathVariable Long prelectionId){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(reservationService.addNewReservation(userDto,prelectionId));
    }

    @ApiOperation("Show all reservations by user login")
    @GetMapping("/showReservationsByLogin/{login}")
    public ResponseEntity<List<ReservationVO>> showReservationsByLogin(@PathVariable String login){
        return ResponseEntity.status(HttpStatus.OK).body(reservationService.showReservationsByLogin(login));
    }

    @ApiOperation("Delete reservation by id")
    @DeleteMapping("/deleteReservation/{id}")
    public ResponseEntity<Long> deleteReservation(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(reservationService.deleteReservation(id));
    }
}
