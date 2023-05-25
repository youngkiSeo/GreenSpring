package com.example.board5;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface Board5Mapper {
    List<Board5Entity> selALLBoard5();
    Board5Entity  selBoard5ById(Board5Entity entity);
    int insBoard5(Board5Entity entity);
    int updBoard5(Board5Entity entity);
    int delBoard5(Board5Entity entity);


}
