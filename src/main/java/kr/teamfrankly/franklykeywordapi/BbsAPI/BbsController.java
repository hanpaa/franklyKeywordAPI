package kr.teamfrankly.franklykeywordapi.BbsAPI;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/bbs")
@RequiredArgsConstructor
public class BbsController {

    private final BbsService bbsService;

    @PostMapping("/{region}/bbs")
    public ResponseEntity<BbsDTO> createBoard(@Validated @RequestBody BbsDTO bbsDTO,
                                                @PathVariable("region") int region) throws Exception{
        bbsDTO.setRegion(region);
        bbsService.createBoardService(bbsDTO);

        return new ResponseEntity<>(bbsDTO, HttpStatus.OK);
    }


    //본인이 쓴 글, 그리고 admin만 수정할 수 있음. 그걸 어떻게 판별할것인가?
    @PutMapping("/{region}/{id}")
    public ResponseEntity<?> updateBoard(@Validated @RequestBody BbsDTO bbsDTO,
                                         @PathVariable("region") int region,
                                         @PathVariable("id")Long id)throws Exception{

        bbsService.updateBoardService(bbsDTO, region, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{region}/{id}")
    public ResponseEntity<BbsDTO> getBoardById(@PathVariable int region,
                                                 @PathVariable Long id) throws Exception{

        try{
            BbsDTO BbsDTO = bbsService.getBbsByIdService(region, id);
            return new ResponseEntity<>(BbsDTO, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }


    }

    @GetMapping("/{region}/{start}")
    public ResponseEntity<BbsDTO> getBoardList(@PathVariable Long start) throws Exception{

//      BbsDTO BbsDTO = boardService.pageNumberBoardList(start);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{region}/{id}")
    public ResponseEntity<?> deleteBoard(@PathVariable("region") int region,
                                         @PathVariable("id") Long id) throws Exception{

        BbsDTO bbsDTO = new BbsDTO();
        bbsDTO.setId(id);
        bbsDTO.setRegion(region);

        bbsService.deleteBoardService(bbsDTO);

        return new ResponseEntity<>(HttpStatus.OK);

    }
}
