package com.green.board10.board;

import com.green.board10.board.model.*;
import com.green.board10.cmt.CmtService;
import com.green.board10.cmt.model.CmtDelDto;
import com.green.board10.cmt.model.CmtRes;
import com.green.board10.cmt.model.CmtSelDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BoardService {
    private final BoardMapper mapper;
    private final CmtService service;


    public BoardService(BoardMapper mapper, CmtService service) {
        this.mapper = mapper;
        this.service = service;
    }
    public int Insboard(BoardInsDto dto){
        return mapper.Insboard(dto);
    }

    public List<BoardVo>selboard(BoardSelDto dto){
        int startIdx = (dto.getPage()-1)* dto.getRow();
        dto.setStartIdx(startIdx);
        return mapper.selboard(dto);
    }

    public BoardDetailAll detail(BoardSelDto dto){
        CmtSelDto cmtdto = new CmtSelDto();
        cmtdto.setIboard(dto.getIboard());
        cmtdto.setPage(1);
        cmtdto.setRow(5);
        CmtRes res = service.CmtSel2(cmtdto);
        BoardDetail boardDetail = mapper.detail(dto);
        return BoardDetailAll.builder().iboard(boardDetail).cmtRes(res).build();
    }
    public int Updboard(BoardUpdDto dto){
        return mapper.Updboard(dto);
    }

    @Transactional(rollbackFor = Exception.class)
    public int BoardDel(BoardDetail dto) throws Exception {
        CmtDelDto cmtdto = new CmtDelDto();
        cmtdto.setIboard(dto.getIboard());
        service.delCmt(cmtdto);
        int result =0;
        result = mapper.deleteboard(dto);
        if (result == 0 ){
            throw  new Exception("삭제 권한 없음");
        }
        return result;
    }

}
