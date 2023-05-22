package com.example.board7;

import com.example.board7.model.BoardDetailVo;
import com.example.board7.model.BoardDto;
import com.example.board7.model.BoardInsDto;
import com.example.board7.model.BoardVo;
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
    public List<BoardVo> selALLBoard(){
        return mapper.selALLBoard();
    }

    public BoardDetailVo selBoardDetail(BoardDto dto){
        return mapper.selBoardDetail(dto);
    }
}
