package com.example.board5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board5")
public class Board5Controller {
    private final Board5Service service;

    @Autowired
    public Board5Controller(Board5Service service){
        this.service= service;
    }
    @GetMapping
    public List<Board5Entity>selALLBoard5(){
        return service.selALLBoard5();
    }
    @GetMapping("/{iboard}")
    public Board5Entity selBoard5ById(@PathVariable int iboard){
        Board5Entity entity = new Board5Entity();
        entity.setIboard(iboard);
        return service.selBoard5ById(entity);
    }
    @PostMapping
    public int PostBoard5(@RequestBody Board5Entity entity){
        return service.insBoard5(entity);
    }

    @PutMapping
    public int PutBoard5(@RequestBody Board5Entity entity){
        return service.updBoard5(entity);
    }

    @DeleteMapping
    public int DelBoard5(int iboard){
        Board5Entity entity = new Board5Entity();
        entity.setIboard(iboard);
        return service.delBoard5(entity);
    }




}
