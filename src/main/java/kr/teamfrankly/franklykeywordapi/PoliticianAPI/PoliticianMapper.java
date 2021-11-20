package kr.teamfrankly.franklykeywordapi.PoliticianAPI;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PoliticianMapper {

    public List<PoliticianDTO> readPoliticianList() throws Exception;

    public PoliticianDTO readPolitician(Long id) throws Exception;

}
