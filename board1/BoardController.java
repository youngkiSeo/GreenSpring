package com.example.board1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //요청 응답담당
@RequestMapping("/board")
public class BoardController {
    private final BoardService service; //di 객체생성을 알아서해주고 싱글톤을 알아서 해준다 Dependency Injection

    @Autowired //자동으로 연결시키는 service 자동연결
    public BoardController(BoardService service){
        this.service = service;
    }

    @PostMapping
    public int boardPost(@RequestBody BoardEntity entity){
        System.out.println(entity);
        return service.insBoard(entity);
    }
}