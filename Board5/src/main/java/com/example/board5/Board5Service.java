package com.example.board5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Board5Service {
    private final Board5Mapper mapper;
    @Autowired
    public Board5Service(Board5Mapper mapper){
        this.mapper=mapper;
    }

    public List<Board5Entity>selALLBoard5(){
        return mapper.selALLBoard5();
    }
    public Board5Entity selBoard5ById(Board5Entity entity){
        return mapper.selBoard5ById(entity);
    }
    public int insBoard5(Board5Entity entity){
        return mapper.insBoard5(entity);
    }
    public int updBoard5(Board5Entity entity){
        return mapper.updBoard5(entity);
    }
    public  int delBoard5(Board5Entity entity){
        return mapper.delBoard5(entity);
    }

}
