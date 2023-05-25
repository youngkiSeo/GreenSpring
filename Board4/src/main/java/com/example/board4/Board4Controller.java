package com.example.board4;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Board4")
public class Board4Controller {

    private final Board4Service service;

    @Autowired
    public Board4Controller(Board4Service service){
        this.service=service;
    }
    @GetMapping
    public List<Board4Entity> selALLBoard4(){
        return service.selALLBoard4();
    }
    @GetMapping("/{iboard}")
    public Board4Entity selBoard4ById(@PathVariable int iboard){
        Board4Entity entity = new Board4Entity();
        entity.setIboard(iboard);
        return service.selBoard4ById(entity);

    }

    @PostMapping
    public int insBoard4(@RequestBody Board4Entity entity){
        return service.insBoard4(entity);
    }
    @PutMapping
    public int upBoard4(@RequestBody Board4Entity entity){
        return service.updBoard4(entity);
    }
    @DeleteMapping
    public int delBoard4(int iboard){
        Board4Entity entity = new Board4Entity();
        entity.setIboard(iboard);
        return service.delBoard4(entity);
    }

}
