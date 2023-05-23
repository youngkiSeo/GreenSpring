package com.example.board7.board;

import com.example.board7.board.model.BoardDetailVo;
import com.example.board7.board.model.BoardDto;
import com.example.board7.board.model.BoardInsDto;
import com.example.board7.board.model.BoardVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //bean 등록 스프링이 알아서 객체생성함
public class BoardService {
    private final BoardMapper mapper;

    @Autowired
    public BoardService(BoardMapper mapper){
        this.mapper = mapper;
    }

    public int insBoard(BoardInsDto dto){
        return mapper.BoardInsDto(dto);
    }
    public int updBoard(BoardDto dto){
        return mapper.updBoard(dto);
    }
    public int delBoard(BoardDto dto){
        return mapper.delBoard(dto);
    }
    public List<BoardVo> selALLBoard(BoardDto dto){

        int ROW_PER_PAGE=dto.getRowLen();
        int startsIdx = (dto.getPage()-1) * ROW_PER_PAGE;
        dto.setStartsIdx(startsIdx);
        dto.setRowLen(ROW_PER_PAGE);
        return mapper.selALLBoard(dto);

    }

    public BoardDetailVo selBoardDetail(BoardDto dto){
        return mapper.selBoardDetail(dto);
    }
}
