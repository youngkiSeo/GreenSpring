package com.example.board7;

import com.example.board7.model.BoardDetailVo;
import com.example.board7.model.BoardDto;
import com.example.board7.model.BoardInsDto;
import com.example.board7.model.BoardVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    int BoardInsDto(BoardInsDto dto); //영향을 끼친 행수가 리턴됨 select 문 제외하고 int 사용가능
    int updBoard(BoardDto dto);
    int delBoard(BoardDto dto);
    List<BoardVo>selALLBoard();
    BoardDetailVo selBoardDetail(BoardDto dto);

}
