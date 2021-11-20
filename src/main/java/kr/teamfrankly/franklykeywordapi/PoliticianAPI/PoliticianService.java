package kr.teamfrankly.franklykeywordapi.PoliticianAPI;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PoliticianService implements PoliticianServiceInterface{

    private final PoliticianMapper politicianMapper;


    @Override
    public List<PoliticianDTO> getPoliticianListService() throws Exception {
        return politicianMapper.readPoliticianList();
    }

    @Override
    public PoliticianDTO getPoliticianByIDService(Long id) throws Exception {
        return politicianMapper.readPolitician(id);
    }
}
