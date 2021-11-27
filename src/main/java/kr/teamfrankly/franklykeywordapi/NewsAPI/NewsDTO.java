package kr.teamfrankly.franklykeywordapi.NewsAPI;

import lombok.Data;

@Data
public class NewsDTO {

    private String resultKeyword;

    private String inputKeyword;

    private String newsURL;

    private String[] urlList;

}
