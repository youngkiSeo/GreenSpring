package com.example.board2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Board2Service {
    private final Board2Mapper mapper;

    @Autowired
    public Board2Service(Board2Mapper mapper){
        this.mapper = mapper;
    }
    public List<Board2Entity> selBoard2(){
        return mapper.selBoard2();
    }

    public Board2Entity selBoard2ById(Board2Entity entity){
        return mapper.selBoard2ById(entity);
    }

    public int insBoard2(Board2Entity entity){
        return mapper.insBoard2(entity);
    }

    public int upBoard2(Board2Entity entity){
        return mapper.upBoard2(entity);
    }
    public int delBoard2(Board2Entity entity){
        return mapper.delBoard2(entity);
    }


}
