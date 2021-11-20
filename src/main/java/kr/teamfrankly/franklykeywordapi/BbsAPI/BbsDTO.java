package kr.teamfrankly.franklykeywordapi.BbsAPI;

import lombok.Data;

import java.util.Date;

@Data
public class BbsDTO {

    private Long id;

    private String author;

    private Date regDate;

    private String title;

    private String content;

    private int region;



}
