package com.example.board7.board;

import com.example.board7.board.model.BoardDetailVo;
import com.example.board7.board.model.BoardDto;
import com.example.board7.board.model.BoardInsDto;
import com.example.board7.board.model.BoardVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    int BoardInsDto(BoardInsDto dto); //영향을 끼친 행수가 리턴됨 select 문 제외하고 int 사용가능
    int updBoard(BoardDto dto);
    int delBoard(BoardDto dto);
    List<BoardVo>selALLBoard(BoardDto dto);
    BoardDetailVo selBoardDetail(BoardDto dto);

}
