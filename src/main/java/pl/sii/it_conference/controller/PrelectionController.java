package pl.sii.it_conference.controller;

import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sii.it_conference.dto.PrelectionVO;
import pl.sii.it_conference.service.PrelectionService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/prelection")
public class PrelectionController {
    private final PrelectionService prelectionService;

    @ApiOperation("Show all prelections")
    @GetMapping("/getAll")
    public ResponseEntity<List<PrelectionVO>> getAllPrelections(){
        return ResponseEntity.status(HttpStatus.OK).body(prelectionService.getAllPrelections());
    }

}
