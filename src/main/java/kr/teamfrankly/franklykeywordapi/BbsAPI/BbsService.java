package kr.teamfrankly.franklykeywordapi.BbsAPI;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@Service
@RequiredArgsConstructor
public class BbsService implements BbsServiceInterface{

    private final BbsMapper bbsMapper;


    @Override
    public BbsDTO getBbsByIdService(int region, Long id) throws Exception {
        return bbsMapper.readBoard(region, id);
    }

    @Override
    public List<BbsDTO> getBbsListService() throws Exception {
        return null;
    }

    @Override
    public void createBoardService(BbsDTO bbsDTO) throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
        String strDate = dateFormat.format(Calendar.getInstance(TimeZone.getTimeZone("Asia/Seoul")).getTime());
        Date date = dateFormat.parse(strDate);
        bbsDTO.setRegDate(date);
        bbsMapper.createBoard(bbsDTO);
    }

    @Override
    public void updateBoardService(BbsDTO bbsDTO, int region, Long targetId) throws Exception {

        BbsDTO targetBoard = bbsMapper.readBoard(region, targetId);
        if(targetBoard.getAuthor().equals(bbsDTO.getAuthor())){
            try{
                bbsDTO.setId(targetId);
                bbsDTO.setRegion(region);
                bbsMapper.updateBoard(bbsDTO);
            }catch(SQLException e){
                System.out.println(e);
                e.printStackTrace();
            }

        }else{
            throw new Exception("author is different");
        }
    }

    @Override
    public void deleteBoardService(BbsDTO bbsDTO) throws Exception {
        bbsMapper.deleteBoard(bbsDTO);
    }

    @Override
    public List<BbsDTO> pageNumberBoardListService(Long pageNumber) throws Exception {
        return null;
    }
}
