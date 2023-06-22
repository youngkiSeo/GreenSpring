package com.green.board11_2.board.model;

import lombok.Data;

@Data
public class BoardVo {
    private int iboard;
    private String title;
    private String ctnt;
    private String nm;
    private String created_at;
}
