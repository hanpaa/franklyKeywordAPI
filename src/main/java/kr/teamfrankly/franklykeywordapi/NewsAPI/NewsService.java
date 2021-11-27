package kr.teamfrankly.franklykeywordapi.NewsAPI;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NewsService implements NewsServiceInterface{

    private final NewsMapper newsMapper;

    @Override
    public NewsDTO getNewsByIdServie(String name) throws Exception {

        NewsDTO newsDTO = new NewsDTO();
        newsDTO = newsMapper.readNews(name);
        newsDTO.setUrlList(newsDTO.getNewsURL().split(","));
        if(newsDTO.getResultKeyword() == "")
            newsDTO.setResultKeyword("키워드가 없습니다. 이 정치인에게 관심을 가져주세요.");

        return newsDTO;
    }
}
