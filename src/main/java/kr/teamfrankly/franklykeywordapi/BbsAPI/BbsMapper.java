package kr.teamfrankly.franklykeywordapi.BbsAPI;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BbsMapper {

    void createBoard(BbsDTO bbsDTO) throws Exception;

    void updateBoard(BbsDTO bbsDTO) throws Exception;

    void deleteBoard(BbsDTO bbsDTO) throws Exception;

    BbsDTO readBoard(int region, Long id)throws Exception;

    List<BbsDTO> readAllBoardList() throws  Exception;

    List<BbsDTO> readPageNumberBoardList(Long pageNumber) throws Exception;


}
