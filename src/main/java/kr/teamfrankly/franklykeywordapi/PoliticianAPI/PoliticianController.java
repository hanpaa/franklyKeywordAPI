package kr.teamfrankly.franklykeywordapi.PoliticianAPI;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/politicians")
@RequiredArgsConstructor
public class PoliticianController {

    private final PoliticianService politicianService;

    @GetMapping("/all")
    public ResponseEntity<List<PoliticianDTO>>PoliticianList() throws Exception{

        return new ResponseEntity<>(politicianService.getPoliticianListService(), HttpStatus.OK);

    }


    @GetMapping("/{id}")
    public ResponseEntity<PoliticianDTO> getPoliticianByID(@PathVariable("id") Long id)throws Exception{

        PoliticianDTO politicianDTO = politicianService.getPoliticianByIDService(id);

        return new ResponseEntity<>(politicianDTO, HttpStatus.OK);

    }

}
