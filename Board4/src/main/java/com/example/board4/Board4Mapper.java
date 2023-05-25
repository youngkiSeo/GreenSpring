package com.example.board4;

import lombok.Data;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface Board4Mapper {
    List<Board4Entity> selALLBoard4();
    Board4Entity selBoard4ById(Board4Entity entity);

    int insBoard4(Board4Entity entity);
    int updBoard4(Board4Entity entity);
    int delBoard4(Board4Entity entity);


}
