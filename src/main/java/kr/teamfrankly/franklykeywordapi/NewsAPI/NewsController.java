package kr.teamfrankly.franklykeywordapi.NewsAPI;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/api/news")
public class NewsController {

    private final NewsService service;

    @GetMapping("/{name}")
    public ResponseEntity<NewsDTO>getNewsById(@PathVariable("name")String name)
            throws Exception{

        NewsDTO newsDTO = service.getNewsByIdServie(name);

        return new ResponseEntity<>(newsDTO,HttpStatus.OK);

    }
}
