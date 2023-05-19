package com.example.board2;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface Board2Mapper {
    List<Board2Entity> selBoard2();
    Board2Entity selBoard2ById(Board2Entity entity);
    int insBoard2(Board2Entity entity);

    int upBoard2(Board2Entity entity);
    int delBoard2(Board2Entity entity);


}
