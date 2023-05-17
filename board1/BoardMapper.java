package com.example.board1;

import org.apache.ibatis.annotations.Mapper;

@Mapper //
public interface BoardMapper {
    void insBoard(BoardEntity entity);
}
