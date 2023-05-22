package com.example.board7.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor //생성자
public class BoardVo {
    private int iboard;
    private String title;
    private String writer;
    private String createdAt;
}
