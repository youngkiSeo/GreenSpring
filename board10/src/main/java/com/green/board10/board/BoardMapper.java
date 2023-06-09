package com.green.board10.board;

import com.green.board10.board.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    int Insboard(BoardInsDto dto);
    List<BoardVo>selboard(BoardSelDto dto);
    BoardDetail detail(BoardSelDto dto);
    int Updboard(BoardUpdDto dto);
    int deleteboard(BoardDetail dto);
}
