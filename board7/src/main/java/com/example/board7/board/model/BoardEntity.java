package com.example.board7.board.model;

import lombok.Data;

@Data //toString, getter setter 등 넣어줌
public class BoardEntity {
    // DB와 1대1 맵핑
    private int iboard;
    private String title;
    private String ctnt;
    private String writer;
    private String createdAt;
    private String updatedAt;
}
