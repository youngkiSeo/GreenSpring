package com.example.board2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board2")
public class Board2Controller {
    private final Board2Service service;
    @Autowired
    public Board2Controller(Board2Service service){
        this.service= service;
    }

    @GetMapping
    public List<Board2Entity> selBoard2(){
        return service.selBoard2();
    }
    @GetMapping("/{iboard}")    //경로변수
    public Board2Entity selBoard2ByID(@PathVariable int iboard){
        Board2Entity entity = new Board2Entity();
        entity.setIboard(iboard);
        return service.selBoard2ById(entity);
    }

    @PostMapping
    public int insBoard2(@RequestBody Board2Entity entity){
        return service.insBoard2(entity);
    }

    @PutMapping
    public int Board2Put(@RequestBody Board2Entity entity){
        return service.upBoard2(entity);
    }
    @DeleteMapping
    public int Board2Del(int iboard){
        Board2Entity entity = new Board2Entity();
        entity.setIboard(iboard);
        return service.delBoard2(entity);
    }
}
