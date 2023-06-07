package com.green.board10.cmt;

import org.springframework.stereotype.Service;

@Service
public class BoardService {
    private final BoardMapper mapper;

    public BoardService(BoardMapper mapper) {
        this.mapper = mapper;
    }

}
