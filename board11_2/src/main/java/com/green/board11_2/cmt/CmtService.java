package com.green.board11_2.cmt;

import com.green.board11_2.cmt.model.CmtEntity;
import com.green.board11_2.cmt.model.CmtRes;
import com.green.board11_2.cmt.model.CmtSelDto;
import com.green.board11_2.cmt.model.CmtVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CmtService {
    private final CmtMapper mapper;
    @Autowired
    public CmtService(CmtMapper mapper) {
        this.mapper = mapper;
    }

    public int CmtIns(CmtEntity entity){
        try{
            int result = mapper.CmtIns(entity);
            if (result == 1){
                return entity.getIboardCmt();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }
    public CmtRes selBoardCmt(CmtSelDto dto){
        int startIdx = (dto.getPage()-1) * dto.getRow();
        dto.setStartIdx(startIdx);
        List<CmtVo> list = mapper.selBoardCmt(dto);
        int rowCnt = mapper.CmtIboardCount(dto.getIboard());
        int maxpage= (int)Math.ceil((double)rowCnt/dto.getRow());
        int isMore = maxpage > dto.getPage() ? 1:0; //0이면 댓글 더 없음 1이면 댓글 더있음

        return CmtRes.builder()
                .list(list)
                .row(rowCnt)
                .maxPage(maxpage)
                .isMore(isMore)
                .build();
    }
    public int UpdCmt(CmtEntity entity){
        return mapper.UpdCmt(entity);
    }

    public int DelCmt(CmtEntity entity){
        return mapper.DelCmt(entity);
    }
}