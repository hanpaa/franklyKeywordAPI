package kr.teamfrankly.franklykeywordapi.PoliticianAPI;

import java.util.List;

public interface PoliticianServiceInterface {

    public List<PoliticianDTO> getPoliticianListService() throws Exception;

    public PoliticianDTO getPoliticianByIDService(Long id) throws Exception;

}
