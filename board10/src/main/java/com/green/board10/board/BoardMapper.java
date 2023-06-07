package com.green.board10.board;

import com.green.board10.board.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    int Insboard(BoardInsDto dto);
    List<BoardVo>selboard(BoardSelDto dto);
    BoardDetail detail(BoardVo dto);
    int Updboard(BoardUpdDto dto);
    int BoardDel(BoardDel dto);
}
