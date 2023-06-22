package com.green.board11_2.board.model;

import lombok.Data;

@Data
public class BoardDetailVo {
    private int iboard;
    private String title;
    private String ctnt;
    private String createdAt;
    private String writer;
    private String writerMainPic;
}
