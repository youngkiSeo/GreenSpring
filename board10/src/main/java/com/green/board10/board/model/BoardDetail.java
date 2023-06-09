package com.green.board10.board.model;

import lombok.Data;

@Data
public class BoardDetail {
    private int iboard;
    private String title;
    private String ctnt;
    private String nm;
    private int iuser;
    private String created_at;
    private String updated_at;
}

