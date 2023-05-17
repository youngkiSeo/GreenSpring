package com.example.board1;


import lombok.Data;

@Data //get set 자동으로 해주는

public class BoardEntity {
    private int iboard;
    private String title;
    private String ctnt;
    private String writer;
    private String createdAt;
    private String updatedAt;

}