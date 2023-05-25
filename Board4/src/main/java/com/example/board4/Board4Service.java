package com.example.board4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Board4Service {
    private final Board4Mapper mapper;

    @Autowired
    public Board4Service(Board4Mapper mapper){
        this.mapper = mapper;
    }

    public List<Board4Entity> selALLBoard4(){
        return mapper.selALLBoard4();
    }

    public Board4Entity selBoard4ById(Board4Entity entity){
        return mapper.selBoard4ById(entity);
    }

    public int insBoard4(Board4Entity entity){
    return mapper.insBoard4(entity);
    }

    public int updBoard4(Board4Entity entity){
        return mapper.updBoard4(entity);
    }

    public int delBoard4(Board4Entity entity){
        return mapper.delBoard4(entity);
    }


}
