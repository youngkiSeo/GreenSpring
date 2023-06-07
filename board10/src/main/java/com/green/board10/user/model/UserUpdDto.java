package com.green.board10.user.model;

import lombok.Data;

@Data
public class UserUpdDto {
    private String uid;
    private String upw;
    private String nm;
    private char gender;
    private String addr;
}
