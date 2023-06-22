package com.green.board11_2.board;

import com.green.board11_2.board.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    int insBoard(BoardInsDto dto);
    int updBoard(BoardUpdDto dto);
    List<BoardVo>selBoard(BoardSelDto dto);
    BoardDetailVo selBoardDetail(BoardSelDto dto);

}
