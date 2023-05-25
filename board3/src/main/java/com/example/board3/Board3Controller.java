package com.example.board3;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board3")
public class Board3Controller {
    private final Board3Service service;

    @Autowired
    public Board3Controller(Board3Service service){
        this.service=service;
    }
    @GetMapping
    public List<Board3Entity> selBoard3(){
        return service.selBoard3();
    }

    @GetMapping("/{iboard}")
    public Board3Entity selBoardById(@PathVariable int iboard){
        Board3Entity entity = new Board3Entity();
        entity.setIboard(iboard);
        return service.selBoardById(entity);
    }

    @PostMapping
    public int insBoard3(@RequestBody Board3Entity entity){
        return service.insBoard(entity);
    }

    @PutMapping
    public int updBoard3(@RequestBody Board3Entity entity){
        return service.updBoard3(entity);
    }
    @DeleteMapping
    public int delBoard3(int iboard){
        Board3Entity entity = new Board3Entity();
        entity.setIboard(iboard);
        return service.delBoard3(entity);
    }





}
