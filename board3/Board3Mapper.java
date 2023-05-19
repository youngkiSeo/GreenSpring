package com.example.board3;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper// DB와 자바연결
public interface Board3Mapper {
    int insBoard(Board3Entity entity); // Board3Mapper.xml 의 insert vlaue 값?을 매개변수로 받아와 -> service로 이동
    List<Board3Entity> selBoard3();
    Board3Entity selBoardById(Board3Entity entity);
    int updBoard3(Board3Entity entity);
    int delBoard3(Board3Entity entity);
}
