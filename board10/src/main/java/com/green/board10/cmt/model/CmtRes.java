package com.green.board10.cmt.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class CmtRes {
    private int maxPage;
    private int row;
    private int isMore;
    private List<CmtVo> list;
}
