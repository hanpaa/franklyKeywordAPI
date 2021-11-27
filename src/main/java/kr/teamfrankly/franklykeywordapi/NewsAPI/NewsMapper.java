package kr.teamfrankly.franklykeywordapi.NewsAPI;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NewsMapper {

    NewsDTO readNews(String name) throws Exception;
}
