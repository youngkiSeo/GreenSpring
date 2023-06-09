package com.green.board10.cmt;
import com.green.board10.cmt.model.*;
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
    public int CmtIns(CmtInsDto dto){
        return mapper.CmtIns(dto);
    }
    public int CmtUpd(CmtUpdDto dto){
        return mapper.CmtUpd(dto);
    }
    public List<CmtVo>CmtSel(CmtSelDto dto){
        int startIdx = (dto.getPage()-1) * dto.getRow();
        dto.setStartIdx(startIdx);
        return mapper.CmtSel(dto);
    }

    public CmtRes CmtSel2(CmtSelDto dto){
        int startIdx = (dto.getPage()-1) * dto.getRow();
        dto.setStartIdx(startIdx);

        List<CmtVo> list = mapper.CmtSel(dto);
        int rowCnt = mapper.selBoardCmtRowCountByIBoard(dto.getIboard());
        int maxPage = (int)Math.ceil((double)rowCnt / dto.getRow());
        int isMore = maxPage > dto.getPage() ? 1 : 0;
        return CmtRes.builder()
                .list(list)
                .isMore(isMore)
                .maxPage(maxPage)
                .row(dto.getRow())
                .build();
    }

    public int delCmt(CmtDelDto dto){
        return mapper.delCmt(dto);
    }
}
