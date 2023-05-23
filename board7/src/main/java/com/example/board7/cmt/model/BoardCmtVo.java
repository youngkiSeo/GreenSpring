package com.example.board7.cmt.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BoardCmtVo {
    private int icmt;
    private String ctnt;
    private String writer;
    private String createdAt;
}
