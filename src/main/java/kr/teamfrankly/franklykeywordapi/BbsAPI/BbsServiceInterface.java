package kr.teamfrankly.franklykeywordapi.BbsAPI;

import java.util.List;

public interface BbsServiceInterface {

    void createBoardService(BbsDTO bbsDTO) throws Exception;

    void updateBoardService(BbsDTO bbsDTO, int region, Long id) throws Exception;

    void deleteBoardService(BbsDTO bbsDTO) throws Exception;

    BbsDTO getBbsByIdService(int region, Long id)throws Exception;

    List<BbsDTO> getBbsListService() throws  Exception;

    List<BbsDTO> pageNumberBoardListService(Long pageNumber) throws Exception;



}
