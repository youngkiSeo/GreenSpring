package com.green.board10.board;

import com.green.board10.board.model.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    private final BoardMapper mapper;

    public BoardService(BoardMapper mapper) {
        this.mapper = mapper;
    }
    public int Insboard(BoardInsDto dto){
        return mapper.Insboard(dto);
    }

    public List<BoardVo>selboard(BoardSelDto dto){
        int startIdx = (dto.getPage()-1)* dto.getRow();
        dto.setStartIdx(startIdx);
        return mapper.selboard(dto);
    }

    public BoardDetail detail(BoardVo dto){
        return mapper.detail(dto);
    }
    public int Updboard(BoardUpdDto dto){
        return mapper.Updboard(dto);
    }

    public int BoardDel(BoardDel dto){
        return mapper.BoardDel(dto);
    }

}
