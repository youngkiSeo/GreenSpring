package com.green.board11_2.board;

import com.green.board11_2.board.model.*;
import com.green.board11_2.cmt.CmtService;
import com.green.board11_2.cmt.model.CmtRes;
import com.green.board11_2.cmt.model.CmtSelDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    private final BoardMapper mapper;
    private final CmtService cmtService;

    @Autowired
    public BoardService(BoardMapper mapper, CmtService cmtService) {
        this.mapper = mapper;
        this.cmtService=cmtService;
    }
    public int InsBoard(BoardInsDto dto){
        return mapper.insBoard(dto);
    }
    public int UpdBoard(BoardUpdDto dto){
        return mapper.updBoard(dto);
    }

    public List<BoardVo> SelBoard (BoardSelDto dto){
        int startIdx = (dto.getPage()-1) * dto.getRow();
        dto.setStartIdx(startIdx);
        return mapper.selBoard(dto);
    }
    public BoardDetailCmtVo selBoardDetail(BoardSelDto dto){
        BoardDetailVo vo = mapper.selBoardDetail(dto);

        CmtSelDto cmtDto = new CmtSelDto();
        cmtDto.setIboard(dto.getIboard());
        cmtDto.setPage(1);
        cmtDto.setRow(5);
        CmtRes cmt = cmtService.selBoardCmt(cmtDto);
        return BoardDetailCmtVo.builder().vo(vo).cmtRes(cmt).build();

    }
}
