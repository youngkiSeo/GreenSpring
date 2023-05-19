package com.example.board3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Board3Service {
    private final Board3Mapper mapper;

    @Autowired
    public Board3Service(Board3Mapper mapper){
        this.mapper=mapper;
    }

    public int insBoard(Board3Entity entity){
        return mapper.insBoard(entity);
    }
    public List<Board3Entity> selBoard3(){
        return mapper.selBoard3();
    }
    public Board3Entity selBoardById(Board3Entity entity){
        return mapper.selBoardById(entity);
    }
    public int updBoard3(Board3Entity entity){
        return mapper.updBoard3(entity);
    }
    public int delBoard3(Board3Entity entity){
        return mapper.delBoard3(entity);
    }
}